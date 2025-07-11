package sudoku.model;

public class Space {
	
	private final boolean fixed;
	private Integer actual;
	private final int expected;
	
	public Space(boolean fixed, int expected) {
		this.fixed = fixed;
		this.expected = expected;
		if(fixed) {
			actual = expected;
		}
	}

	public boolean isFixed() {
		return fixed;
	}

	public Integer getActual() {
		return actual;
	}
	
	public void setActual(Integer actual) {
		if(fixed) return;
		this.actual = actual;
	}

	public void clearSpace() {
		setActual(null);
	}
	
	public int getExpected() {
		return expected;
	}

}
