package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Name: Keaton Raymond
 *Class: CS 1450 - 002
 *Assignment 7
 *Due: 4/28/2020
 *Description:  This program will read data from a file for a player object, 
 *				then will insert those players into an array based on their seat number
 *				they will be moved from the array into a waing queue, then into 
 *				the escape room to obtain a score, then into the results priority queue
 *				the program will output the player's name and seat whos is being moved 
 *				from their seats to the waiting queue
 *				then each player's name, score, and whoever is the current leader in the same
 *				order they entered in
 *				finally, the results of the escape room with each player's name and score
 *				from a priority queue, it will output the results from highest to lowest score
 */

public class RaymondKeatonAssignment7 {

	public static void main(String[] args) throws IOException {

		//opening the file and creating a scanner for the file
		File playerFile = new File("players.txt");
		Scanner readPlayers = new Scanner(playerFile);

		//variables for reading file, and the player array
		String player;
		int rank, seat;
		Player[] seats = new Player[25];

		//constructors for a game and controller
		EscapeGame game = new EscapeGame();
		EscapeGameController controller = new EscapeGameController();

		//reading data from file and creating each player object
		while(readPlayers.hasNext()) {
			player = readPlayers.next();
			rank = readPlayers.nextInt();
			seat = readPlayers.nextInt();

			seats[seat] = new Player(player, rank, seat);
		} //end while

		//calling the three methods from controller class to "play the game"
		controller.movePlayersIntoEscapeRoom(seats, game);
		controller.simulateGame(game);
		controller.displayResults(game);

		//closing file
		readPlayers.close();
	} //end main method
} //end main class

//player class, represents each player object
class Player implements Comparable<Player> {
	//private data fields for this class
	private String name;
	private int ranking, seat, score;

	//constructor, sets private variables to incoming values
	public Player(String name, int ranking, int seat) {
		this.name = name;
		this.ranking = ranking;
		this.seat = seat;
		this.score = 0;
	} //end constructor

	//getters and setters for this class
	public String getName() {
		return name;
	} //end get name
	public int getRanking() {
		return ranking;
	} //end get ranking
	public int getSeat() {
		return seat;
	} //end get seat
	public int getScore() {
		return score;
	} //end get score
	public void setScore(int score) {
		this.score = score;
	} //end set score

	//comparable interface to compare 2 players' scores
	@Override
	public int compareTo(Player otherPlayer) {
		if(score < otherPlayer.getScore())
			return -1;
		else if(score == otherPlayer.getScore())
			return 0;
		else
			return 1;
	} //end compareTo
} //end player class

//method for each player to play the game
class EscapeRoom {
	//private method to give each player a score from 1-100 based on their name and ranking
	private int hash(String key) {
		int hash = 0;

		for (int i = 0; i < key.length(); i++) {
			hash += key.charAt(i);
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}   

		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);

		return Math.abs(hash);
	} //end hash

	//method to call to hash, make the score between 0-100, and return a score
	public int tryToEscape(String playerName, int playerRanking) {
		String key = playerName + playerRanking;
		int score = hash(key) %  (101);
		return score;
	} //end try to escape
} //end escape room class

//class with all of the commands needed for playing the game
class EscapeGame {
	//private data fields for this class
	private Queue<Player> waitingQueue = new LinkedList<>();
	private PriorityQueue resultsQueue = new PriorityQueue();
	private EscapeRoom escapeRoom = new EscapeRoom();

	//constructor
	public EscapeGame() {
	} //end constructor

	//if waiting queue is empty, return true
	public boolean isWaitingQueueEmpty() {
		return waitingQueue.isEmpty();
	} //end is waiting queue empty

	//method to add a new player to the end of the waiting queue
	public void addPlayerToWaitingQueue(Player player) {
		waitingQueue.offer(player);
	} //end add player to waiting queue

	//method to remove the first player from the waiting queue
	public Player removePlayerFromWaitingQueue() {
		return waitingQueue.poll();
	} //end remove player from waiting queue

	//if results queue is empty, return true
	public boolean isResultsQueueEmpty() {
		return resultsQueue.isEmpty();
	} //end is results queue empty

	//method to add a player to the end of the results queue
	public void addPlayerToResultsQueue(Player player) {
		resultsQueue.offer(player);
	} //end add player to results queue

	//method to remove player from the top of the results queue
	public Player removePlayerFromResultsQueue() {
		return resultsQueue.remove();
	} //end remove player from results queue

	//method to return player at front of results queue but not remove them
	public Player peekResultsQueue() {
		return resultsQueue.peek();
	} //end peek results queue

	//method to call to the escape room class for each player to play the game and get a score
	public int tryToEscape(String playerName, int playerRanking) {
		return escapeRoom.tryToEscape(playerName, playerRanking);
	} //end try to escape
} //end escape game class

//class for "playing the game" and printing all of the results and outputs
class EscapeGameController {
	//method to move the players from waiting room into the waiting queue
	public void movePlayersIntoEscapeRoom(Player[] seats, EscapeGame escapeGame) {
		//heading for moving players
		System.out.println("Controller: Moving players from outside seats into escape game:");
		System.out.println("--------------------------------------------------------------------------------");
		
		//for loop checking all of the seats and adding all of the players to waiting queue
		for(int i=0; i<seats.length; i++) {
			if(seats[i] != null) {
				escapeGame.addPlayerToWaitingQueue(seats[i]);
				System.out.printf("Moved to escape game: %s from outside seat %d\n",
						seats[i].getName(), seats[i].getSeat());
			} //end if
		} //end for
	} //end movePlayersIntoEscapeRoom

	//method to simulate an escape game
	public void simulateGame(EscapeGame escapeGame) {
		//heading for the game simulation
		System.out.println("\nController: Starting Escape Game - "
				+ "moving players waiting in line into escape room:");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Player\t\tScore\t\tCurrent leader");
		System.out.println("-------------------------------------------------------------------------------------");
		
		//while loop to let each player "play the game"
		while(escapeGame.isWaitingQueueEmpty() != true) {
			//set the player removed from the waiting queue equal to a hold player
			//as to not remove a player every time a command is called, then set their score
			Player playing = escapeGame.removePlayerFromWaitingQueue();
			playing.setScore(escapeGame.tryToEscape(playing.getName(), playing.getRanking()));
			escapeGame.addPlayerToResultsQueue(playing);

			//print the person who is playing's name, score, and who is #1
			System.out.printf("%s\t\t%d\t\t%s\n", 
					playing.getName(), playing.getScore(), escapeGame.peekResultsQueue().getName());
		} //end while
	} //end simulateGame 

	//method to print the final results of the escape room
	public void displayResults(EscapeGame escapeGame) {
		//the heading for this particular set of data
		System.out.println("\nController: Escape Room Results");
		System.out.println("-------------------------------");
		System.out.println("Player\t\tScore");
		System.out.println("-------------------------------");
		
		//while there are still players in the queue, print the "escape room results" in order
		while(escapeGame.isResultsQueueEmpty() != true) {
			Player results = escapeGame.removePlayerFromResultsQueue();
			System.out.printf("%s\t\t%d\n", results.getName(), results.getScore());
		} //end while
	} //end display results
} //end escape game controller class

//class for self built priority queue
class PriorityQueue {
	//initializing private data types
	private Player[] list = new Player[30];
	private int numPlayers;

	//constructor for the priority queue
	public PriorityQueue() {
		this.numPlayers = 0;
	} //end constructor

	//method to see if the queue is empty or not
	public boolean isEmpty() {
		if(numPlayers == 0)
			return true;
		else
			return false;
	} //end isEmpty

	//returns the player at the front of the queue without removing
	public Player peek() {
		if(numPlayers == 0)
			return null;
		else
			return list[numPlayers];
	} //end peek

	//method to add a player to the priority queue, sorts after each addition
	public boolean offer(Player player) {
		//if no more space for players
		if(numPlayers == list.length)
			return false;
		else {
			numPlayers++;
			list[numPlayers] = player;
			selectionSort(list, numPlayers);
			return true;
		} //end else
	} //end offer

	//method to remove the first player from the priority queue
	public Player remove() {
		Player hold = list[numPlayers];
		list[numPlayers] = null;
		numPlayers--;
		return hold;
	} //end remove

	private void selectionSort(Player[] list, int numPlayers) {
		//selection sort from notes adapted for use with objects and compareTo
		for(int i=0; i<list.length-1; i++) {

			Player smallest = list[i];
			int smallestIndex = i;

			for(int j=i+1; j<list.length; j++) {
				if(list[j] != null && smallest != null && list[j].compareTo(smallest) == -1) {
					smallest = list[j];
					smallestIndex = j;
				} //end j for
			} //end for

			if(smallestIndex != i) {
				list[smallestIndex] = list[i];
				list[i] = smallest;
			} //end if
		} //end i for

	} //end selection sort
} //end priority queue class