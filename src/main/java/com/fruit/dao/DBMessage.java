package com.fruit.dao;

import com.fruit.Object.MessageObject;
import java.util.List;

public interface DBMessage {
    public int AddMessageOne(int id,String username,String email,String url,String question,String message);
    public int UpdateMessageOne(int id,String username,String email,String url,String question,String message);
    public int DelOne(int id);
    public List<MessageObject> FindMessageAll();
}
