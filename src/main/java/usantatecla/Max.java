package usantatecla;

public class Max extends Boundary {

  public Max(double value) {
    super(value);
  }

  public boolean isWithin(double value) {
    return this.value > value;
  }

  @Override
  public String toString() {
    return this.value + ")";
  }

}
