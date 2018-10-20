package Program13;

import java.util.Arrays;

public class College {
	private String[] sArr;
	private Department[] d;

	public College(String[] sArr, Department[] d) {
		super();
		this.sArr = sArr;
		this.d = d;
	}

	public String[] getsArr() {
		return sArr;
	}

	public Department[] getD() {
		return d;
	}

	@Override
	public String toString() {
		return "College [sArr=" + Arrays.toString(sArr) + ", d=" + Arrays.toString(d) + "]";
	}
}
