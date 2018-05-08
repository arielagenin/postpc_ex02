package com.arielagenin.postpc_ex02;


import java.util.Date;

public class Message {

    private String username;
    private String time;
    private String message;


    Message(String username , String msg , Date timeStamp){
        this.username = username;
        this.message = msg;
        this.time = timeStamp.toString();

    }

    /**
     * @return The name of the message writer.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return The time that the message was sent at.
     */
    public String getTime()
    {
        return time;
    }

    /**
     * @return The message content.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message A String representing a message content.
     * Sets the given message content to be the current message content.
     */
    public void setMessage(String message)
    {
        this.message = message;
    }


    /**
     * @param time A string representing time.
     * sets the time that the message was sent at to the given time.
     */
    public void setTime(String time)
    {
        this.time = time;
    }





}
