package Program20;

public class Dragon extends Animal {
	private int rangeFire;
	private int dragonHead;

	public Dragon(String name, int rangeFire, int dragonHead) {
		super(name, false, 4);
		this.rangeFire = rangeFire > 0 ? rangeFire : 0;
		this.dragonHead = dragonHead > 0 ? dragonHead : 1;
	}

	public int getRangeFire() {
		return rangeFire;
	}

	public void setRangeFire(int rangeFire) {
		this.rangeFire = rangeFire > 0 ? rangeFire : 0;
	}

	public int getDragonHead() {
		return dragonHead;
	}

	public void setDragonHead(int dragonHead) {
		this.dragonHead = dragonHead > 0 ? dragonHead : 1;
	}

	@Override
	public String toString() {
		return super.toString() + "\nDragon [rangeFire=" + rangeFire + ", dragonHead=" + dragonHead + "]\n";
	}

}
