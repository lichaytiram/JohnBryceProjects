
public class try111 {
	public static void main(String[] args) {
		System.out.println(SongDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB"));
	}

	public static String SongDecoder(String song) {
		return song.replace("WUB", " ").trim().replace("  ", " ").replace("  ", " ");
	}
}
