import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

/**
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */

/**
 * A simple applet that uses the Java 1.0 event handling model.
 */
public class Scribble extends Applet {
  private int lastx, lasty;    // remember last mouse coordinates
  Button clearButton;         // the Clear button
  Graphics g;                  // A Graphics object for drawing

  /**
   * Initialize the button and the Graphics object.
   */
  public void init() {
    clearButton = new Button("Clear");
    this.add(clearButton);
    g = this.getGraphics();
  }

  /**
   * Respond to mouse clicks.
   *
   * @param e The event happening.
   * @param x Current x coordinates.
   * @param y Current y coordinates.
   * @return true for successful reassignment.
   */
  public boolean mouseDown(Event e, int x, int y) {
    lastx = x;
    lasty = y;
    return true;
  }

  /**
   * Respond to mouse drags.
   *
   * @param e The event happening.
   * @param x Current x coordinates.
   * @param y Current y coordinates.
   * @return true for successful reassignment.
   */
  public boolean mouseDrag(Event e, int x, int y) {
    g.setColor(Color.black);
    g.drawLine(lastx, lasty, x, y);
    lastx = x;
    lasty = y;
    return true;
  }

  /**
   * Respond to key presses.
   *
   * @param e   The event happening.
   * @param key The key.
   * @return True if key was "c", false otherwise.
   */
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Respond to Button clicks.
   *
   * @param e   The event happening.
   * @param arg Object.
   * @return True if target is button, false otherwise.
   */
  public boolean action(Event e, Object arg) {
    if (e.target == clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Convenience method to erase the scribble.
   */
  public void clear() {
    g.setColor(this.getBackground());
    g.fillRect(0, 0, bounds().width, bounds().height);
  }
}