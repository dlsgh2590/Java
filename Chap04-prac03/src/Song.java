
public class Song {
	private String title;
	private String artist;
	private int year;
	private String country;
	
	
	public Song() { }
	public Song(String title, String artist, int year, String country){
			this.title = title;
			this.artist = artist;//가 부른
			this.year = year;//년
			this.country = country;//국적의
	}
	
	
	public void show() {
			System.out.print(year + "년");
			System.out.print(country + "국적의");
			System.out.print(artist + "가 부른");
			System.out.println(title);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song myFavorite = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
		myFavorite.show();
	}

}
//년 