import org.junit.Assert;
import org.junit.Test;

public class TestMyArrayList {

    @Test
    public void TestGetSize() throws Exception {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        Assert.assertEquals(3, simple.getSize());
    }

    @Test
    public void TestPushBack() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.pushBack(1893);


        Assert.assertEquals(1893, simple.getDate(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void TestPopFront() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.popFront();

        Assert.assertEquals(1891, simple.getDate(0));
        Assert.assertEquals(1892, simple.getDate(1));

        Assert.assertNull(simple.getDate(2));

    }

    @Test
    public void TestPushFront() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.pushFront(1889);

        Assert.assertEquals(1889, simple.getDate(0));
        Assert.assertEquals(1890, simple.getDate(1));
        Assert.assertEquals(1891, simple.getDate(2));
        Assert.assertEquals(1892, simple.getDate(3));

        Assert.assertEquals(4, simple.getSize());
    }

    @Test
    public void TestInsert1() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.insert(5555, 2);

        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));
        Assert.assertEquals(5555, simple.getDate(2));
        Assert.assertEquals(1892, simple.getDate(3));

    }

    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void TestInsert2() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.insert(5555, 2);

        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));
        Assert.assertEquals(5555, simple.getDate(2));
        Assert.assertEquals(1892, simple.getDate(3));

        simple.insert(6666, 8);
        simple.getDate(8);

    }

    @Test
    public void TestRemoveAt() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.removeAt(2);

        Assert.assertEquals(2, simple.getSize());

        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));

        simple.removeAt(5);

        Assert.assertEquals(2, simple.getSize());

        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));
    }

    @Test
    public void TestRemove() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(5555);
        simple.add(1892);
        simple.add(5555);

        simple.remove(6666);
        Assert.assertEquals(5, simple.getSize());

        simple.remove(5555);
        Assert.assertEquals(4, simple.getSize());

        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));
        Assert.assertEquals(1892, simple.getDate(2));
        Assert.assertEquals(5555, simple.getDate(3));
    }

    @Test
    public void TestRemoveAll() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(5555);
        simple.add(1892);
        simple.add(5555);

        simple.removeAll(6666);
        Assert.assertEquals(5, simple.getSize());

        simple.removeAll(5555);
        Assert.assertEquals(3, simple.getSize());

        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));
        Assert.assertEquals(1892, simple.getDate(2));
    }

    @Test
    public void Test1PopBack() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.popBack();
        Assert.assertEquals(2, simple.getSize());
        Assert.assertEquals(1890, simple.getDate(0));
        Assert.assertEquals(1891, simple.getDate(1));

        simple.popBack();
        simple.popBack();
        simple.popBack();
    }

    @Test(expected = NegativeArraySizeException.class)
    public void Test2PopBack() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        simple.popBack();
        simple.popBack();
        simple.popBack();
        simple.popBack();
    }

    @Test
    public void TestClear() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        Assert.assertEquals(3, simple.getSize());
        simple.clear();
        Assert.assertEquals(0, simple.getSize());
    }

    @Test
    public void TestIsEmpty() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);

        Assert.assertFalse(simple.isEmpty());
        simple.clear();
        Assert.assertTrue(simple.isEmpty());
    }

    @Test
    public void TestTrimToSize() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);
        simple.add(1893);
        simple.pushBack(5555);

        Assert.assertEquals(5, simple.getSize());
        Assert.assertEquals(6, simple.getCapasity());
        simple.trimToSize();
        Assert.assertEquals(simple.getSize(), simple.getCapasity());
    }

    @Test
    public void TestIndexOf() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);
        simple.add(1893);
        simple.add(1894);
        simple.add(1895);

        Assert.assertEquals(-1, simple.indexOf(5555));
        Assert.assertEquals(2, simple.indexOf(1892));
    }

    @Test
    public void TestLastIndexOf() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(5555);
        simple.add(1893);
        simple.add(1894);
        simple.add(5555);

        Assert.assertEquals(-1, simple.lastIndexOf(6666));
        Assert.assertEquals(5, simple.lastIndexOf(5555));
        System.out.println();
    }

    @Test
    public void TestReverse() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);
        simple.add(1893);
        simple.add(1894);
        simple.add(1895);

        simple.reverse();

        Assert.assertNull(simple.getDate(0));
        Assert.assertNull(simple.getDate(1));
        Assert.assertEquals(1895, simple.getDate(2));
        Assert.assertEquals(1894, simple.getDate(3));
        Assert.assertEquals(1893, simple.getDate(4));
        Assert.assertEquals(1892, simple.getDate(5));
        Assert.assertEquals(1891, simple.getDate(6));
        Assert.assertEquals(1890, simple.getDate(7));
    }

    @Test
    public void TestShufe() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);
        simple.add(1893);

        simple.shufe();

        Assert.assertNotEquals(0, simple.indexOf(1890));
        Assert.assertNotEquals(1, simple.indexOf(1891));
        Assert.assertNotEquals(2, simple.indexOf(1892));
        Assert.assertNotEquals(3, simple.indexOf(1893));

        Assert.assertEquals(simple.getSize(), 4);
    }

    @Test
    public void TestEquals() {
        MyArrayList<Integer> simple1 = new MyArrayList<Integer>(3);
        simple1.add(1890);
        simple1.add(1891);
        simple1.add(1892);
        simple1.add(1893);

        MyArrayList<Integer> simple2 = new MyArrayList<Integer>(3);
        simple2.add(1890);
        simple2.add(1891);
        simple2.add(1892);
        simple2.add(1893);

        Assert.assertFalse(simple1 == simple2);
        Assert.assertTrue(simple1.equals(simple2));
        Assert.assertEquals(simple1.getDate(0), simple2.getDate(0));
        Assert.assertEquals(simple1.getDate(1), simple2.getDate(1));
        Assert.assertEquals(simple1.getDate(2), simple2.getDate(2));
        Assert.assertEquals(simple1.getDate(3), simple2.getDate(3));
    }

    @Test
    public void TestGetElementAt() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);
        simple.add(1893);

        Assert.assertEquals(simple.getElementAt(0), (Integer) 1890);
        Assert.assertEquals(simple.getElementAt(1), (Integer) 1891);
        Assert.assertEquals(simple.getElementAt(2), (Integer) 1892);
        Assert.assertEquals(simple.getElementAt(3), (Integer) 1893);
        Assert.assertNull(simple.getElementAt(10));
    }

    @Test
    public void TestClone() {
        MyArrayList<Integer> simple = new MyArrayList<Integer>(3);
        simple.add(1890);
        simple.add(1891);
        simple.add(1892);
        simple.add(1893);

        MyArrayList<Integer> simple2 = simple.clone();

        Assert.assertFalse(simple == simple2);
        Assert.assertTrue(simple.equals(simple2));
    }
}
