package model;

public class FemaleUser extends User{
	int lookingforAge;
	
	String gendint, lookingforOcc, lookingforHobby, lookingforMusic;
	public FemaleUser(String name, int age, String occ, String hobby, String music, String major, String campus, String gendint, int lookingforAge, String lookingforOcc, String lookingforHobby, String lookingforMusic) {
		super(name, age, occ, hobby, music, major, campus);
		this.lookingforAge = lookingforAge;
		this.lookingforOcc = lookingforOcc;
		this.lookingforHobby = lookingforHobby;
		this.lookingforMusic = lookingforMusic;
	}
	public int getLookingforAge() {
		return lookingforAge;
	}
	public void setLookingforAge(int lookingforAge) {
		this.lookingforAge = lookingforAge;
	}
	public String getGendint() {
		return gendint;
	}
	public void setGendint(String gendint) {
		this.gendint = gendint;
	}
	public String getLookingforOcc() {
		return lookingforOcc;
	}
	public void setLookingforOcc(String lookingforOcc) {
		this.lookingforOcc = lookingforOcc;
	}
	public String getLookingforHobby() {
		return lookingforHobby;
	}
	public void setLookingforHobby(String lookingforHobby) {
		this.lookingforHobby = lookingforHobby;
	}
	public String getLookingforMusic() {
		return lookingforMusic;
	}
	public void setLookingforMusic(String lookingforMusic) {
		this.lookingforMusic = lookingforMusic;
	}
}
