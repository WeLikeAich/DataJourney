package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Game;

public abstract class Room implements Serializable{
	protected int RoomLevel;
	protected Room LeftRoom;
	protected Room RightRoom;
	protected Room PreviousRoom;
	protected boolean Visited;
	protected boolean NextRoomsBuilt;
	protected boolean HasBeenActivated = false;

	public Room() {
		RoomLevel = 1;
	}
	
	public Room(Room room){
		PreviousRoom = room;
		RoomLevel = room.RoomLevel+1;
	}
	
	public int getRoomLevel() {
		return RoomLevel;
	}

	public Room getLeftRoom() {
		return LeftRoom;
	}

	public Room getRightRoom() {
		return RightRoom;
	}

	public Room getPreviousRoom() {
		return PreviousRoom;
	}

	public void setRoomLevel(int roomLevel) {
		RoomLevel = roomLevel;
	}

	public void setLeftRoom(Room leftRoom) {
		LeftRoom = leftRoom;
	}

	public void setRightRoom(Room rightRoom) {
		RightRoom = rightRoom;
	}

	public void setPreviousRoom(Room previousRoom) {
		PreviousRoom = previousRoom;
	}

	public void setVisited(boolean visited) {
		Visited = visited;
	}

	public void setNextRoomsBuilt(boolean nextRoomsBuilt) {
		NextRoomsBuilt = nextRoomsBuilt;
	}

	public abstract void generateEvent(Party party);
	
	protected abstract String generateEventDialogue();
	
	public boolean getHasBeenActivated() {
		return HasBeenActivated;
	} 
}
