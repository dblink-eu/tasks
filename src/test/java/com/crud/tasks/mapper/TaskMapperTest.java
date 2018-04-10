package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testTaskMapper() {
        //Given
        Task task = new Task(1L, "test", "test");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);
        Task mappedTask = taskMapper.mapToTask(mappedTaskDto);
        //Then
        Assert.assertEquals(1L, (long)mappedTaskDto.getId());
        Assert.assertEquals("test", taskDtos.get(0).getTitle());
        Assert.assertEquals("test", mappedTask.getContent());
    }
}