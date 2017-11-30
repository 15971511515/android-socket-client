package com.open.net.client.structures.message;

import java.util.LinkedList;

/**
 * author       :   long
 * created on   :   2017/11/30
 * description  :   写队列
 */

public final class MessageWriteQueen {

    private MessageBuffer       mWriteMessageBuffer = new MessageBuffer();
    public  LinkedList<Message> mQueen = new LinkedList<>();//真正的消息队列

    public Message build(byte[] src , int offset , int length){
        return mWriteMessageBuffer.build(src,offset,length);
    }

    public void put(Message msg){
        mQueen.add(msg);
    }

    public void remove(Message msg){
        mQueen.remove(msg);
        mWriteMessageBuffer.release(msg);
    }
}