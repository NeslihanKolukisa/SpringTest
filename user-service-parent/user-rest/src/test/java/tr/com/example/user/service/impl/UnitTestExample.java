package tr.com.example.user.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.example.user.dao.UsersRepository;
import tr.com.example.user.document.UserDocument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitTestExample {

    @Mock
    UsersRepository usersRepository;

    @InjectMocks
    AuthImpl auth;

    @BeforeEach
    public void setUp(){
        System.out.println("SetUP");
    }

    @Test
    @Order(1)
    @DisplayName("When Test")
    public void getAllUser(){
        when(usersRepository.findAll()).thenReturn(Collections.singletonList(new UserDocument("neslihan","123")));
        assertEquals(1, auth.getAllUser().size());
    }

    @Test
    @Order(2)
    @DisplayName("Mock List Test")
    public void listMockTest(){
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    @Order(3)
    @DisplayName("Generic Parameter")
    public void genericParameter(){
        List mock = mock(List.class);
        when(mock.get(anyInt())).thenReturn("test");
        assertEquals("test", mock.get(1));
        assertEquals("test", mock.get(2));
    }

    @Test
    @Order(4)
    @DisplayName("Verify")
    public void verifyTest(){
        List mock = mock(List.class);
        Object val1 = mock.get(0);
        Object val2 = mock.get(1);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(8);
    }

    @Test
    @Order(5)
    @DisplayName("Argument capture")
    public void argumentCaptureTest(){
        List mock = mock(List.class);
        mock.add("test");
        ArgumentCaptor captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("test", captor.getValue());
    }

    @Test
    @Order(6)
    @DisplayName("Spy")
    public void spyTest(){
        ArrayList spyList = spy(ArrayList.class);
        List mock = mock(List.class);
        spyList.add("test");
        mock.add("test");
        System.out.println(spyList.get(0));
        System.out.println(mock.get(0));

        assertEquals(1, spyList.size());
        assertEquals(0, mock.size());
    }
}