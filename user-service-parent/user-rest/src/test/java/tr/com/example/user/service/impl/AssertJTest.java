package tr.com.example.user.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AssertJTest {

    int hesaplanan = 0;
    int sonuc = 10;

    String isim = "ASSERT JTEST";
    String kIsim = "ASSERT JTEST";

    public String getOrnekDeger(final String key){
        Map<String, String> ornekler = new HashMap<String, String>();
        ornekler.put("ornek1", "deger 1");
        ornekler.put("ornek2", "deger 2");
        ornekler.put("ornek3", "deger 3");
        return ornekler.get(key);
    }

    public class A {
        private int i;
        public A(int i){ this.i = i; }
        @Override
        public boolean equals(Object o){
            if(this == o){ return true; } else
                if(o == null){ return false;} else
                    if(getClass() != o.getClass()){ return false; } else {
                        final A a = (A) o;
                        return Objects.equals(a, a);
                    }
        }
    }
    final A a1 = new A(0);
    final A a2 = new A(0);

    int [] dizi1 = {2,4,6};
    int [] dizi2 = {1,3,5};
    int [] dizi3 = {1,3,5};


    @Test
    @DisplayName("Assert True - AssertJ Test")
    public void testAssertTrue(){
        assertTrue(this.hesaplanan != this.sonuc);
    }

    @Test
    @DisplayName("Assert False - AssertJ Test")
    public void testAssertFalse(){
        assertFalse(this.hesaplanan == this.sonuc);
    }

    @Test
    @DisplayName("Assert Null - AssertJ Test")
    public void testAssertNull(){
        assertNull(getOrnekDeger("ornek4"));
    }

    @Test
    @DisplayName("Assert Not Null - AssertJ Test")
    public void testAssertNotNull(){
        assertNotNull(getOrnekDeger("ornek1"));
    }

    @Test
    @DisplayName("Assert Equals - AssertJ Test")
    public void testAssertEquals(){
        assertEquals(this.isim, this.kIsim);
    }

    @Test
    @DisplayName("Assert Same - AssertJ Test")
    public void testAssertSame(){
        assertSame(this.isim, this.kIsim);
    }

    @Test
    @DisplayName("Assert Same Equals Farkı - AssertJ Test")
    public void testAssertEqualsSameDifference(){
        assertEquals(a1, a2);
    }

    @Test
    @DisplayName("Assert Same Equals Farkı - AssertJ Test")
    public void testAssertSameEqualsDifference(){
        assertSame(a1, a1);
    }

    @Test
    @DisplayName("Assert Array Equals - AssertJ Test")
    public void testAssertArrayEquals(){
        assertArrayEquals(dizi2, dizi3);
    }

}
