package usantatecla;

public class Min extends Boundary{

	public Min(double value) {
      super(value);
    }

    @Override
	public boolean isWithin(double value) {
      return this.value < value;
    }

    @Override
	public String toString() {
		return "(" + this.value;
	}

}
