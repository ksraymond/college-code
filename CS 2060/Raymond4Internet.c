#include <stdio.h>
#include <stdlib.h>

struct listNode{
    int data;
    struct listNode *next;
};

struct listNode header = {0, NULL};

void insert(int num) {
    struct listNode *temp, *prev, *next;
    temp = (struct listNode*)malloc(sizeof(struct listNode));
    temp->data = num;
    temp->next = NULL;
    if(!header){
        header=temp;
        
    } 
	else {
        prev = NULL;
        next = header;
        while(next && next->data<=num){
            prev = next;
            next = next->next;
        }
        
        if(!next){
            prev->next = temp;
        } 
        
		else if(prev){
            temp->next = prev->next;
            prev-> next = temp;
    	}
    	
		else {
            temp->next = header;
            header = temp;
        }            
           
    }
}

int main(int argc, char * argv[]){
    int num;
    struct listNode *p;
    
    do {
        printf("Enter a number");
        scanf("%d",&num);
        if(num > 0) {
            header = insert(num);
        }
    } while(num > 0);
    
    p = header;
    printf("\nThe numbers are:\n");
    while(p) {
        printf("%d ", p->data);
        p = p->next;
    }
    free_list(header);
    return 0;
}

void free_list() {
    struct listNode *prev = header;
    struct listNode *cur = header;
    while(cur) {
        prev = cur;
        cur = prev->next;
        free(prev);
    }       
}
