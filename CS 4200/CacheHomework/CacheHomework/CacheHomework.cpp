#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include "Header.h"

void LRU()
{
	LruPlru lru[4];
	uint32_t count;
	uint32_t dataIndex = 0;
	uint32_t tagIndex = 0;
	uint32_t tag = 0;
	uint32_t way = 0;
	bool hit = false;
	uint8_t way0 = 0;
	uint8_t way1 = 0;
	uint8_t way2 = 0;
	uint8_t way3 = 0;
	uint32_t totalHits = 0;

	memset(&lru, 0, sizeof(struct LruPlru) * 4);

	for (count = 0; count < 4; count++)
		lru[count].history = 0xE4;

	for (count = 0; count < SIZE; count++)
	{
		hit = false;
		tag = Addr[count] >> 6;
		dataIndex = (Addr[count] >> 2) & 0x0F;
		tagIndex = (Addr[count] >> 4) & 0x03;

		for (way = 0; way < 4; way++)
		{
			if ((lru[tagIndex].Way[way].v == 1) && (lru[tagIndex].Way[way].Tag == tag))
			{
				hit = true;
				totalHits++;
				break;
			}
		}

		way0 = lru[tagIndex].history & 0x03;
		way1 = (lru[tagIndex].history >> 2) & 0x03;
		way2 = (lru[tagIndex].history >> 4) & 0x03;
		way3 = (lru[tagIndex].history >> 6) & 0x03;

		printf("Cache Index Before: %d, %d, %d, %d\n", way3, way2, way1, way0);

		if (hit == true) {
			if (way == way0)
				lru[tagIndex].history = (way0 << 6) | (way3 << 4) | (way2 << 2) | way1;
			else if (way == way1)
				lru[tagIndex].history = (way1 << 6) | (way3 << 4) | (way2 << 2) | way0;
			else if (way == way2)
				lru[tagIndex].history = (way2 << 6) | (way3 << 4) | (way1 << 2) | way0;
			else
				lru[tagIndex].history = (way3 << 6) | (way2 << 4) | (way1 << 2) | way0;
		}
		else
		{
			way = way0;
			lru[tagIndex].history = (way0 << 6) | (way3 << 4) | (way2 << 2) | way1;
			lru[tagIndex].Way[way].Tag = tag;
			lru[tagIndex].Way[way].v = 0x01;
			lru[tagIndex].Way[way].data[0] = 0xD0;
			lru[tagIndex].Way[way].data[1] = 0xD1;
			lru[tagIndex].Way[way].data[2] = 0xD2;
			lru[tagIndex].Way[way].data[3] = 0xD3;
		}

		printf("Sequence #: %02d\n", count);
		printf("Way #: %d\n", way);
		printf("Address = %X\n", Addr[count]);
		printf("V = %d\n", lru[tagIndex].Way[way].v);
		printf("tag = %08X\n", lru[tagIndex].Way[way].Tag);
		printf("D0 c.data.index = %X\n", dataIndex);
		printf("D1 c.tag.index = %X\n", tagIndex);
		printf("D2 History Stack = %d, %d, %d, %d\n",
			((lru[tagIndex].history >> 6) & 0x03),
			((lru[tagIndex].history >> 4) & 0x03),
			((lru[tagIndex].history >> 2) & 0x03),
			(lru[tagIndex].history & 0x03));
		printf("D3 Status = %s\n\n", ((hit) ? "Hit" : "Miss"));
	}

	printf("Total Hits: %d\n", totalHits);
}

void PLRU()
{
	LruPlru plru[4];
	uint32_t count;
	uint32_t dataIndex = 0;
	uint32_t tagIndex = 0;
	uint32_t tag = 0;
	uint32_t way = 0;
	bool hit = false;
	uint8_t b0 = 0;
	uint8_t b1 = 0;
	uint8_t b2 = 0;
	uint32_t totalHits = 0;

	memset(&plru, 0, sizeof(struct LruPlru) * 4);

	for (count = 0; count < 4; count++)
		plru[count].history = 0xE4;

	for (count = 0; count < SIZE; count++)
	{
		hit = false;
		tag = Addr[count] >> 6;
		dataIndex = (Addr[count] >> 2) & 0x0F;
		tagIndex = (Addr[count] >> 4) & 0x03;

		for (way = 0; way < 4; way++)
		{
			if ((plru[tagIndex].Way[way].v == 1) && (plru[tagIndex].Way[way].Tag == tag))
			{
				hit = true;
				totalHits++;
				break;
			}
		}

		b0 = plru[tagIndex].history & 0x01;
		b1 = (plru[tagIndex].history >> 1) & 0x01;
		b2 = (plru[tagIndex].history >> 2) & 0x01;

		if (hit == true) {
			if (way == 0)
				plru[tagIndex].history = (b2 << 2) | 0x03;
			else if (way == 1)
				plru[tagIndex].history = (b2 << 2) | 0x02;
			else if (way == 2)
				plru[tagIndex].history = 0x4 | b0;
			else
				plru[tagIndex].history = 0x0 | b0;
		}
		else
		{
			if (b1 == 1)
			{
				if (b2 == 0)
					way = 2;
				else
					way = 3;
			}
			else
			{
				if (b0 == 0)
					way = 0;
				else
					way = 1;
			}

			plru[tagIndex].Way[way].data[1] = 0xD1;
			plru[tagIndex].Way[way].data[2] = 0xD2;
			plru[tagIndex].Way[way].data[3] = 0xD3;
			plru[tagIndex].Way[way].Tag = tag;
			plru[tagIndex].Way[way].v = 1;

			if (way == 0)
				plru[tagIndex].history = (b2 << 2) | 0x03;
			else if (way == 1)
				plru[tagIndex].history = (b2 << 2) | 0x02;
			else if (way == 2)
				plru[tagIndex].history = 0x4 | b0;
			else
				plru[tagIndex].history = 0x0 | b0;
		}

		b0 = (plru[tagIndex].history >> 0) & 0x01;
		b1 = (plru[tagIndex].history >> 1) & 0x01;
		b2 = (plru[tagIndex].history >> 2) & 0x01;

		printf("Sequence #: %02d\n", count);
		printf("Way #: %d\n", way);
		printf("Address = %X\n", Addr[count]);
		printf("V = %d\n", plru[tagIndex].Way[way].v);
		printf("tag = %08X\n", plru[tagIndex].Way[way].Tag);
		printf("D0 c.data.index = %X\n", dataIndex);
		printf("D1 c.tag.index = %X\n", tagIndex);
		printf("D2 History Stack = %d, %d, %d\n", b2, b1, b0);
		printf("D3 Status = %s\n\n", ((hit) ? "Hit" : "Miss"));
	}

	printf("Total Hits: %d\n", totalHits);
}

int main()
{
	printf("----------------------\n");
	printf("LRU\n");
	printf("----------------------\n");
	LRU();
	printf("\n----------------------\n");
	printf("PLRU\n");
	printf("----------------------\n");
	PLRU();
	return 0;
}