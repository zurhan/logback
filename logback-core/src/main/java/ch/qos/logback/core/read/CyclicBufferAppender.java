package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.helpers.CyclicBuffer;

public class CyclicBufferAppender extends AppenderBase {

  
  CyclicBuffer cb;
  int maxSize = 512;
  
  public void start() {
    
    cb = new CyclicBuffer(maxSize);
    super.start();
  }
  
  
  @Override
  protected void append(Object eventObject) {
    if(!isStarted()) {
      return;
    }
    cb.add(eventObject);
  }

  int getLength() {
    return cb.length();
  }

  Object get(int i) {
    return cb.get(i);
  }
  
  
  public Layout getLayout() {
    return null;
  }

  public void setLayout(Layout layout) {
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

}
