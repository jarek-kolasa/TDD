package jUnit.assertionsExample;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;


/**
 * Assertion example using AssertJ
 */
public class AssertionAssertJTest {

    @Test
    public void tryAssertTrue() {
        Rectangle rectangle = new Rectangle(10, 10);

        assertThat(rectangle.isSquare()).isTrue();
    }

    @Test
    public void tryAssertFalse() {
        Rectangle rectangle = new Rectangle(9, 10);

        assertThat(rectangle.isSquare()).isFalse();
    }

    @Test
    public void tryAssertTrueWithCommentIfFalse() {
        Rectangle rectangle = new Rectangle(10, 10);

        assertThat(rectangle.isSquare())
                .describedAs("Only rectangle with the same width and height is a square")
                .isTrue();
    }

    @Test
    public void tryAssertNull() {
        Object value = null;

        assertThat(value).isNull();
    }

    @Test
    public void tryAssertNotNull() {
        Rectangle rectangle = new Rectangle(9, 10);

        assertThat(rectangle).isNotNull();
    }

    @Test
    public void tryAssertEquals() {
        assertThat(new Rectangle(2,8).getArea()).isEqualTo(16);
    }

    @Ignore("tryAssertEqualsWithStrings - This test should not work correctly")
    @Test
    public void tryAssertEqualsWithStrings() {
        assertThat("Hello\nWorld\nnow").isEqualTo("Hello\nWORLD\nnow");
    }

    @Test
    public void tryAssertNotEquals() {
        assertThat(new Rectangle(1, 3).getArea()).isNotEqualTo(99999);
    }

    @Test
    public void tryAssertEqualsWithDouble() {
        double aspectRatio = new Rectangle(1, 3).getAspectRatio();

        assertThat(aspectRatio).isCloseTo(0.3333333333, offset(0.001));
    }

//    @Ignore("tryAssertEqualsWithObject - Objects are not the same")
    @Test
    public void tryAssertEqualsWithObject() {
        assertThat(new Rectangle(1, 1)).isEqualTo(new Rectangle(1, 1));
    }

//    @Ignore("tryAssertSame - Objects are not the same")
    @Test
    public void tryAssertSame() {
        Rectangle example1 = new Rectangle(4, 5);
        Rectangle example1SecondReference = example1;

        assertThat(example1).isSameAs(example1SecondReference);

        Rectangle duplicateOfExample1 = new Rectangle(4, 5);

        assertThat(example1).isNotSameAs(duplicateOfExample1);
        assertThat(example1).isEqualTo(duplicateOfExample1);
    }


    @Test
    public void tryAssertArray(){
        Rectangle rectangle = new Rectangle(5, 6);

        assertThat(rectangle.getSides()).containsExactly(5,6);
    }

    @Test
    public void tryAssertList(){
        Rectangle rectangle = new Rectangle(7, 8);

        assertThat(rectangle.getSidesList()).containsExactly(7, 8);
    }
}
