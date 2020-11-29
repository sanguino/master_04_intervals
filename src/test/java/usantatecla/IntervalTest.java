package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left;
  private Point right;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
  }

  @Test
  public void givenIntervalWhenIsIntersectedWithIntervalThenTrue() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval minIntersect = new IntervalBuilder().open(left.getVeryLess()).open(right.getVeryLess()).build();
    Interval maxIntersect = new IntervalBuilder().open(left.getVeryGreater()).open(right.getVeryGreater()).build();
    Interval insideIntersect = new IntervalBuilder().open(left.getVeryGreater()).open(right.getVeryLess()).build();
    Interval outsideIntersect = new IntervalBuilder().open(left.getVeryLess()).open(right.getVeryGreater()).build();

    assertTrue(interval.isIntersected(minIntersect));
    assertTrue(interval.isIntersected(maxIntersect));
    assertTrue(interval.isIntersected(insideIntersect));
    assertTrue(interval.isIntersected(outsideIntersect));
  }


  @Test
  public void givenIntervalOpenOpenWhenIsIntersectedWithIntervalThenTrue() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    Interval minIntersectEqualMin = new IntervalBuilder().open(left.getEquals()).open(right.getVeryLess()).build();
    Interval minIntersectEqualMax = new IntervalBuilder().open(left.getVeryLess()).open(right.getEquals()).build();
    Interval maxIntersectEqualMin = new IntervalBuilder().open(left.getEquals()).open(right.getVeryGreater()).build();
    Interval maxIntersectEqualMax = new IntervalBuilder().open(left.getVeryGreater()).open(right.getEquals()).build();
    Interval equal = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();

    assertTrue(interval.isIntersected(minIntersectEqualMin));
    assertTrue(interval.isIntersected(minIntersectEqualMax));
    assertTrue(interval.isIntersected(maxIntersectEqualMin));
    assertTrue(interval.isIntersected(maxIntersectEqualMax));
    assertFalse(interval.isIntersected(equal));
  }

  @Test
  public void givenIntervalCloseCloseWhenIsIntersectedWithIntervalThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    Interval minIntersectEqualMin = new IntervalBuilder().closed(left.getEquals()).closed(right.getVeryLess()).build();
    Interval minIntersectEqualMax = new IntervalBuilder().closed(left.getVeryLess()).closed(right.getEquals()).build();
    Interval maxIntersectEqualMin = new IntervalBuilder().closed(left.getEquals()).closed(right.getVeryGreater()).build();
    Interval maxIntersectEqualMax = new IntervalBuilder().closed(left.getVeryGreater()).closed(right.getEquals()).build();
    Interval equal = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();

    assertTrue(interval.isIntersected(minIntersectEqualMin));
    assertTrue(interval.isIntersected(minIntersectEqualMax));
    assertTrue(interval.isIntersected(maxIntersectEqualMin));
    assertTrue(interval.isIntersected(maxIntersectEqualMax));
    assertTrue(interval.isIntersected(equal));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = new IntervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

}