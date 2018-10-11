// file: Program2.java
// generated by: mashc
// from: Program2.mash

public class Program2 extends Program2$SUPER {
 
            protected static java.lang.String mash_nxt_program_name = 
               "Program2";

protected static final int TOUCH = lejos.nxt.SensorConstants.TYPE_SWITCH;

protected static final int LIGHT_FLOOD = lejos.nxt.SensorConstants.TYPE_LIGHT_ACTIVE;

protected static final int LIGHT_NXT_FLOOD = lejos.nxt.SensorConstants.TYPE_LIGHT_ACTIVE;

protected static final int LIGHT_NOFLOOD = lejos.nxt.SensorConstants.TYPE_LIGHT_INACTIVE;

protected static final int LIGHT_NXT_NOFLOOD = lejos.nxt.SensorConstants.TYPE_LIGHT_INACTIVE;

protected static final int LIGHT_RCX = - lejos.nxt.SensorConstants.TYPE_LIGHT_ACTIVE;

protected static final int ROTATION_RCX = lejos.nxt.SensorConstants.TYPE_ANGLE;

protected static final int SOUND = lejos.nxt.SensorConstants.TYPE_SOUND_DB;

protected static final int PROXIMITY = lejos.nxt.SensorConstants.TYPE_REFLECTION;

protected static final int A = 5;

protected static final int B = 6;

protected static final int C = 7;

protected static final int[] PIANO = lejos.nxt.Sound.PIANO;

protected static final int[] FLUTE = lejos.nxt.Sound.FLUTE;

protected static final int[] XYLOPHONE = lejos.nxt.Sound.XYLOPHONE;

protected static final int LCD_WIDTH = lejos.nxt.LCD.SCREEN_WIDTH;

protected static final int LCD_HEIGHT = lejos.nxt.LCD.SCREEN_HEIGHT;

protected static final int LCD_COLUMNS = lejos.nxt.LCD.DISPLAY_CHAR_WIDTH;

protected static final int LCD_LINES = lejos.nxt.LCD.DISPLAY_CHAR_DEPTH;

protected static final int MAX_INT = java.lang.Integer.MAX_VALUE;

protected static final int MIN_INT = java.lang.Integer.MIN_VALUE;

protected static final double PI = java.lang.Math.PI;

public static void mash_nxt_fatal(java.lang.String msg) {
            lejos.nxt.Motor.A.stop();
            lejos.nxt.Motor.B.stop();
            lejos.nxt.Motor.C.stop();
            lejos.nxt.LCD.clearDisplay();
            lejos.nxt.LCD.drawString(" ERROR DETECTED ", 0, 0, true);
            lejos.nxt.LCD.drawString("prog: " + mash_nxt_program_name, 0, 1);
            lejos.nxt.Sound.buzz();
            int i = 0;
            while (i < msg.length() && i / 16 < 6) {
               lejos.nxt.LCD.drawString(msg.substring(i, java.lang.Math.min(i + 16, 
                  msg.length())), 0, 2 + i / 16);
               i = i + 16;
            } 
            while (true)
               ;
         }

protected static lejos.nxt.SensorPort mash_nxt_whichSensorPort(
               int port) {
               if (port == 1) {
                  return lejos.nxt.SensorPort.S1;
               } else if (port == 2) {
                  return lejos.nxt.SensorPort.S2;
               } else if (port == 3) {
                  return lejos.nxt.SensorPort.S3;
               } else if (port == 4) {
                  return lejos.nxt.SensorPort.S4;
               } else {
                  mash_nxt_fatal("port " + port + " is not a sensor port.");
                  return null;
               }
            }

protected static int[] mash_nxt_sensorTypes = new int[5];

protected static java.lang.Object[] mash_nxt_sensorObjects = 
            	new java.lang.Object[5];

protected static void mash_nxt_setUpSensor(int port, int type) {
               lejos.nxt.SensorPort s = mash_nxt_whichSensorPort(port);
               mash_nxt_sensorTypes[port] = type;
               if (type == TOUCH) {
                  mash_nxt_sensorObjects[port] = new lejos.nxt.TouchSensor(s);
               } else if (type == LIGHT_FLOOD) {
                  mash_nxt_sensorObjects[port] = 
                     new lejos.nxt.LightSensor(s, true);
               } else if (type == LIGHT_NOFLOOD) {
                  mash_nxt_sensorObjects[port] = 
                     new lejos.nxt.LightSensor(s, false);
               } else if (type == LIGHT_RCX) {
                  mash_nxt_sensorObjects[port] = 
                     new lejos.nxt.addon.RCXLightSensor(s);
                  ((lejos.nxt.addon.RCXLightSensor) 
                     mash_nxt_sensorObjects[port]).setFloodlight(true);
               } else if (type == ROTATION_RCX) {
                  mash_nxt_sensorObjects[port] = 
                     new lejos.nxt.addon.RCXRotationSensor(s);
               } else if (type == SOUND) {
                  mash_nxt_sensorObjects[port] = 
                    new lejos.nxt.SoundSensor(s, false);
               } else if (type == PROXIMITY) {
                  mash_nxt_sensorObjects[port] = 
                     new lejos.nxt.UltrasonicSensor(s);
               } else {
                  mash_nxt_fatal("setUpSensor: Unknown sensor type " + type);
               }
            }

protected static lejos.nxt.Motor mash_nxt_whichMotorPort(int port) {
               if (port == A) {
                  return lejos.nxt.Motor.A;
               } else if (port == B) {
                  return lejos.nxt.Motor.B;
               } else if (port == C) {
                  return lejos.nxt.Motor.C;
               } else {
                  mash_nxt_fatal("port " + port + " is not an output port.");
                  return null;
               }
            }

protected static void mash_nxt_waitForPush(int port) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   TOUCH) {
                  mash_nxt_fatal("waitForPush: port " + port + 
                     " is not set up as a touch sensor.");
               }
               lejos.nxt.TouchSensor s = 
                  (lejos.nxt.TouchSensor) mash_nxt_sensorObjects[port];
               while (s.isPressed()) {
               }
               while (!s.isPressed()) {
               }
            }

protected static void mash_nxt_waitForLetGo(int port) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   TOUCH) {
                  mash_nxt_fatal("waitForLetGo: port " + port + 
                     " is not set up as a touch sensor.");
               }
               lejos.nxt.TouchSensor s = 
                  (lejos.nxt.TouchSensor) mash_nxt_sensorObjects[port];
               while (!s.isPressed()) {
               }
               while (s.isPressed()) {
               }
            }

protected static boolean mash_nxt_isPushed(int port) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   TOUCH) {
                  mash_nxt_fatal("isPushed: port " + port + 
                     " is not set up as a touch sensor.");
               }
               return ((lejos.nxt.TouchSensor) mash_nxt_sensorObjects[port])
                  .isPressed();
            }

protected static void mash_nxt_waitForLighter(int port, int dif) {
               if (mash_nxt_sensorTypes[port] == LIGHT_FLOOD ||
                   mash_nxt_sensorTypes[port] == LIGHT_NOFLOOD) {
                  lejos.nxt.LightSensor s = 
                     (lejos.nxt.LightSensor) mash_nxt_sensorObjects[port];
                  int init = s.readValue();
                  while (s.readValue() < init + dif) {
                  }
               } else if (mash_nxt_sensorTypes[port] == LIGHT_RCX) {
                  lejos.nxt.addon.RCXLightSensor s = 
                     (lejos.nxt.addon.RCXLightSensor) 
                     mash_nxt_sensorObjects[port];
                  int init = s.getLightValue();
                  while (s.getLightValue() < init + dif) {
                  }
               } else {
                  mash_nxt_fatal("waitForLighter: port " + port + " is not set"
                     + " up as light sensor.");
               }
            }

protected static void mash_nxt_waitForLight(int port, int light) {
               if (mash_nxt_sensorTypes[port] == LIGHT_FLOOD ||
                   mash_nxt_sensorTypes[port] == LIGHT_NOFLOOD) {
                  lejos.nxt.LightSensor s = 
                     (lejos.nxt.LightSensor) mash_nxt_sensorObjects[port];
                  int init = s.readValue();
                  while (s.readValue() < light) {
                  }
               } else if (mash_nxt_sensorTypes[port] == LIGHT_RCX) {
                  lejos.nxt.addon.RCXLightSensor s = 
                     (lejos.nxt.addon.RCXLightSensor) 
                     mash_nxt_sensorObjects[port];
                  int init = s.getLightValue();
                  while (s.getLightValue() < light) {
                  }
               } else {
                  mash_nxt_fatal("waitForLight: port " + port + " is not set up"
                     + " as light sensor.");
               }
            }

protected static void mash_nxt_waitForDarker(int port, int dif) {
               if (mash_nxt_sensorTypes[port] == LIGHT_FLOOD ||
                   mash_nxt_sensorTypes[port] == LIGHT_NOFLOOD) {
                  lejos.nxt.LightSensor s = 
                     (lejos.nxt.LightSensor) mash_nxt_sensorObjects[port];
                  int init = s.readValue();
                  while (s.readValue() > init - dif) {
                  }
               } else if (mash_nxt_sensorTypes[port] == LIGHT_RCX) {
                  lejos.nxt.addon.RCXLightSensor s = 
                     (lejos.nxt.addon.RCXLightSensor) 
                     mash_nxt_sensorObjects[port];
                  int init = s.getLightValue();
                  while (s.getLightValue() > init - dif) {
                  }
               } else {
                  mash_nxt_fatal("waitForDarker: port " + port + " is not set"
                     + " up as light sensor.");
               }
            }

protected static void mash_nxt_waitForDark(int port, int light) {
               if (mash_nxt_sensorTypes[port] == LIGHT_FLOOD ||
                   mash_nxt_sensorTypes[port] == LIGHT_NOFLOOD) {
                  lejos.nxt.LightSensor s = 
                     (lejos.nxt.LightSensor) mash_nxt_sensorObjects[port];
                  int init = s.readValue();
                  while (s.readValue() > light) {
                  }
               } else if (mash_nxt_sensorTypes[port] == LIGHT_RCX) {
                  lejos.nxt.addon.RCXLightSensor s = 
                     (lejos.nxt.addon.RCXLightSensor) 
                     mash_nxt_sensorObjects[port];
                  int init = s.getLightValue();
                  while (s.getLightValue() > light) {
                  }
               } else {
                  mash_nxt_fatal("waitForDark: port " + port + " is not set up"
                     + " as light sensor.");
               }
            }

protected static int mash_nxt_getLight(int port) {
               if (mash_nxt_sensorTypes[port] == LIGHT_FLOOD ||
                   mash_nxt_sensorTypes[port] == LIGHT_NOFLOOD) {
                   return ((lejos.nxt.LightSensor) 
                      mash_nxt_sensorObjects[port]).readValue();
               } else if (mash_nxt_sensorTypes[port] == LIGHT_RCX) {
                   return ((lejos.nxt.addon.RCXLightSensor) 
                      mash_nxt_sensorObjects[port]).getLightValue();
               } else {
                  mash_nxt_fatal("getLight: port " + port + " is not set up"
                     + " as light sensor.");
                  return 0;
               }
            }

protected static void mash_nxt_setFloodlight(
               int port, boolean floodlight) {
               if (mash_nxt_sensorTypes[port] == LIGHT_FLOOD ||
                   mash_nxt_sensorTypes[port] == LIGHT_NOFLOOD) {
                   ((lejos.nxt.LightSensor) 
                      mash_nxt_sensorObjects[port]).setFloodlight(floodlight);
               } else {
                  mash_nxt_fatal("setFloodlight: port " + port + " is not set"
                     + " up as NXT light sensor.");
               }
            }

protected static void mash_nxt_waitForLouder(int port, int dif) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   SOUND) {
                  mash_nxt_fatal("waitForLouder: port " + port + 
                     " is not set up as a sound sensor.");
               }
               lejos.nxt.SoundSensor s = 
                  (lejos.nxt.SoundSensor) mash_nxt_sensorObjects[port];
               int init = s.readValue();
               while (s.readValue() < init + dif) {
               }
            }

protected static void mash_nxt_waitForLoud(int port, int volume) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   SOUND) {
                  mash_nxt_fatal("waitForLoud: port " + port + 
                     " is not set up as a sound sensor.");
               }
               lejos.nxt.SoundSensor s = 
                  (lejos.nxt.SoundSensor) mash_nxt_sensorObjects[port];
               while (s.readValue() < volume) {
               }
            }

protected static void mash_nxt_waitForQuieter(int port, int dif) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   SOUND) {
                  mash_nxt_fatal("waitForQuieter: port " + port + 
                     " is not set up as a sound sensor.");
               }
               lejos.nxt.SoundSensor s = 
                  (lejos.nxt.SoundSensor) mash_nxt_sensorObjects[port];
               int init = s.readValue();
               while (s.readValue() > init - dif) {
               }
            }

protected static void mash_nxt_waitForQuiet(int port, int volume) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   SOUND) {
                  mash_nxt_fatal("waitForQuiet: port " + port + 
                     " is not set up as a sound sensor.");
               }
               lejos.nxt.SoundSensor s = 
                  (lejos.nxt.SoundSensor) mash_nxt_sensorObjects[port];
               while (s.readValue() > volume) {
               }
            }

protected static int mash_nxt_getVolume(int port) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   SOUND) {
                  mash_nxt_fatal("getVolume: port " + port + 
                     " is not set up as a sound sensor.");
               }
               return ((lejos.nxt.SoundSensor) 
                  mash_nxt_sensorObjects[port]).readValue();
            }

protected static void mash_nxt_waitForNearer(int port, int dif) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   PROXIMITY) {
                  mash_nxt_fatal("waitForNearer: port " + port + 
                     " is not set up as an ultrasound sensor.");
               }
               lejos.nxt.UltrasonicSensor s = 
                  (lejos.nxt.UltrasonicSensor) mash_nxt_sensorObjects[port];
               int init = s.getDistance();
               while (s.getDistance() > init - dif) {
               }
            }

protected static void mash_nxt_waitForNear(int port, int distance) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   PROXIMITY) {
                  mash_nxt_fatal("waitForNear: port " + port + 
                     " is not set up as an ultrasound sensor.");
               }
               lejos.nxt.UltrasonicSensor s = 
                  (lejos.nxt.UltrasonicSensor) mash_nxt_sensorObjects[port];
               while (s.getDistance() > distance) {
               }
            }

protected static void mash_nxt_waitForFurther(int port, int dif) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   PROXIMITY) {
                  mash_nxt_fatal("waitForFurther: port " + port + 
                     " is not set up as an ultrasound sensor.");
               }
               lejos.nxt.UltrasonicSensor s = 
                  (lejos.nxt.UltrasonicSensor) mash_nxt_sensorObjects[port];
               int init = s.getDistance();
               while (s.getDistance() < init + dif) {
               }
            }

protected static void mash_nxt_waitForFar(int port, int distance) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   PROXIMITY) {
                  mash_nxt_fatal("waitForFar: port " + port + 
                     " is not set up as an ultrasound sensor.");
               }
               lejos.nxt.UltrasonicSensor s = 
                  (lejos.nxt.UltrasonicSensor) mash_nxt_sensorObjects[port];
               while (s.getDistance() < distance) {
               }
            }

protected static int mash_nxt_getDistance(int port) {
               if (port < 1 || port > 4 || mash_nxt_sensorTypes[port] != 
                   PROXIMITY) {
                  mash_nxt_fatal("getDistance: port " + port + 
                     " is not set up as an ultrasound sensor.");
               }
               return ((lejos.nxt.UltrasonicSensor) 
                  mash_nxt_sensorObjects[port]).getDistance();
            }

protected static void mash_nxt_resetRotation(int port) {
               if (1 <= port && port <= 4) {
                  if (mash_nxt_sensorTypes[port] != ROTATION_RCX) {
                     mash_nxt_fatal("resetRotation: port " + port + 
                        " is not set up as an RCX rotation sensor.");
                  }
                  ((lejos.nxt.addon.RCXRotationSensor)
                     mash_nxt_sensorObjects[port]).resetTachoCount();
               } else if (A <= port && port <= C) {
                  mash_nxt_whichMotorPort(port).resetTachoCount();
               } else {
                  mash_nxt_fatal("resetRotation: " + port + " is not a port.");
               }
            }

protected static void mash_nxt_waitForRotation(
               int port, int rotation) {
               rotation = java.lang.Math.abs(rotation);
               if (1 <= port && port <= 4) {
                  if (mash_nxt_sensorTypes[port] != ROTATION_RCX) {
                     mash_nxt_fatal("waitForRotation: port " + port + 
                        " is not set up as an RCX rotation sensor.");
                  }
                  lejos.nxt.addon.RCXRotationSensor s = 
                     (lejos.nxt.addon.RCXRotationSensor)
                     mash_nxt_sensorObjects[port];
                  int init = s.getTachoCount();
                  while (java.lang.Math.abs(s.getTachoCount() - init) < rotation) {
                  }
               } else if (A <= port && port <= C) {
                  lejos.nxt.Motor m = mash_nxt_whichMotorPort(port);
                  int init = m.getTachoCount();
                  while (java.lang.Math.abs(m.getTachoCount() - init) < rotation) {
                  }
               } else {
                  mash_nxt_fatal("waitForRotation: " + port + 
                     " is not a port.");
               }
            }

protected static int mash_nxt_getRotation(int port) {
               if (1 <= port && port <= 4) {
                  if (mash_nxt_sensorTypes[port] != ROTATION_RCX) {
                     mash_nxt_fatal("getRotation: port " + port + 
                        " is not set up as an RCX rotation sensor.");
                  }
                  return ((lejos.nxt.addon.RCXRotationSensor)
                     mash_nxt_sensorObjects[port]).getTachoCount();
               } else if (A <= port && port <= C) {
                  return mash_nxt_whichMotorPort(port).getTachoCount();
               } else {
                  mash_nxt_fatal("getRotation: " + port + " is not a port.");
                  return 0;
               }
            }

protected static void mash_nxt_motorForward(int port, int power) {
               lejos.nxt.Motor m = mash_nxt_whichMotorPort(port);
               m.setPower(power);
               m.forward();
            }

protected static void mash_nxt_motorBackward(int port, int power) {
               lejos.nxt.Motor m = mash_nxt_whichMotorPort(port);
               m.setPower(power);
               m.backward();
            }

private static void mash_sleep(int ms) {
                try {
                   java.lang.Thread.sleep(ms);
                } catch (java.lang.Exception e) {
                }
             }

protected static final int LIFT = C;

protected static final int DOOR = A;

protected static final int TOP = 1;

protected static final int BOT = 2;

public static void main(java.lang.String[] mash_args_param) 
         throws Exception {
            // Listen to the ENTER button. There are spurious calls on startup.
            lejos.nxt.Button.ENTER.addButtonListener(
               new lejos.nxt.ButtonListener() {
                  public void buttonPressed(lejos.nxt.Button b) {
                     mash_nxt_onPressEnter();
                  }
                  public void buttonReleased(lejos.nxt.Button b) {
                     mash_nxt_onReleaseEnter();
                  }
               });
            // Listen to the LEFT button.
            lejos.nxt.Button.LEFT.addButtonListener(
               new lejos.nxt.ButtonListener() {
                  public void buttonPressed(lejos.nxt.Button b) {
                     mash_nxt_onPressLeft();
                  }
                  public void buttonReleased(lejos.nxt.Button b) {
                     mash_nxt_onReleaseLeft();
                  }
               });
            // Listen to the RIGHT button.
            lejos.nxt.Button.RIGHT.addButtonListener(
               new lejos.nxt.ButtonListener() {
                  public void buttonPressed(lejos.nxt.Button b) {
                     mash_nxt_onPressRight();
                  }
                  public void buttonReleased(lejos.nxt.Button b) {
                     mash_nxt_onReleaseRight();
                  }
               });
            // Listen to the ESCAPE button.
            lejos.nxt.Button.ESCAPE.addButtonListener(
               new lejos.nxt.ButtonListener() {
                  public void buttonPressed(lejos.nxt.Button b) {
                     mash_nxt_onPressEscape();
                  }
                  public void buttonReleased(lejos.nxt.Button b) {
                     mash_nxt_onReleaseEscape();
                  }
               });
            // Display a message to say what we are running.
            lejos.nxt.LCD.drawString("Running:", 0, 0);
            lejos.nxt.LCD.drawString(mash_nxt_program_name, 0, 1);
            // turn off motor speed regulation by default
            lejos.nxt.Motor.A.regulateSpeed(false);
            lejos.nxt.Motor.B.regulateSpeed(false);
            lejos.nxt.Motor.C.regulateSpeed(false);
{
mash_nxt_setUpSensor(Program2.TOP, TOUCH);
mash_nxt_setUpSensor(Program2.BOT, TOUCH);
Program2.up();
mash_nxt_waitForPush(Program2.TOP);
mash_nxt_resetRotation(Program2.LIFT);
Program2.down();
mash_nxt_waitForPush(Program2.BOT);
int rot = mash_nxt_getRotation(Program2.LIFT);
int ground = rot;
int floor1 = (rot / 3) * 2;
int floor2 = rot / 3;
int floor3 = 0;
lejos.nxt.LCD.drawString("" + rot, 0, 3);
lejos.nxt.LCD.drawString("" + floor1, 0, 4);
lejos.nxt.LCD.drawString("" + floor2, 0, 5);
lejos.nxt.LCD.drawString("" + floor3, 0, 6);
while (mash_nxt_getRotation(Program2.LIFT) != floor2)
{
Program2.up();
}
Program2.stop();
Program2.door();
while (mash_nxt_getRotation(Program2.LIFT) != floor3)
{
Program2.up();
}
Program2.stop();
Program2.door();
while (mash_nxt_getRotation(Program2.LIFT) != floor1)
{
Program2.down();
}
Program2.stop();
Program2.door();
while (mash_nxt_getRotation(Program2.LIFT) != ground)
{
Program2.down();
}
Program2.stop();
Program2.door();
}
} // end of main method


protected static void up()  {
mash_nxt_motorBackward(Program2.LIFT, 100);
}

protected static void down()  {
mash_nxt_motorForward(Program2.LIFT, 100);
}

protected static void stop()  {
mash_nxt_whichMotorPort(Program2.LIFT).stop();
}

protected static void door()  {
mash_nxt_motorBackward(Program2.DOOR, 100);
mash_sleep(3000);
mash_nxt_whichMotorPort(Program2.DOOR).stop();
mash_sleep(1500);
mash_nxt_motorForward(Program2.DOOR, 100);
mash_sleep(3000);
mash_nxt_whichMotorPort(Program2.DOOR).stop();
}
} // end of the program class
         
         class Program2$SUPER {
         
            protected static void mash_nxt_onPressEnter() {
            }
            
            protected static void mash_nxt_onReleaseEnter() {
               lejos.nxt.Sound.beep();
            }
            
            protected static void mash_nxt_onPressLeft() {
            }
            
            protected static void mash_nxt_onReleaseLeft() {
               lejos.nxt.Sound.beep();
            }
            
            protected static void mash_nxt_onPressRight() {
            }
            
            protected static void mash_nxt_onReleaseRight() {
               lejos.nxt.Sound.beep();
            }
            
            protected static void mash_nxt_onPressEscape() {
            }
            
            protected static void mash_nxt_onReleaseEscape() {
               System.exit(0);
            }
            
            protected static void mash_nxt_onChange1(int oldValue, 
               int newValue) {
               if (oldValue != newValue) {
                  lejos.nxt.Sound.beep();
               } else {
               }
            }
            
            protected static void mash_nxt_onChange2(int oldValue, 
               int newValue) {
               if (oldValue != newValue) {
                  lejos.nxt.Sound.beep();
               } else {
               }
            }
            
            protected static void mash_nxt_onChange3(int oldValue, 
               int newValue) {
               if (oldValue != newValue) {
                  lejos.nxt.Sound.beep();
               } else {
               }
            }
            
            protected static void mash_nxt_onChange4(int oldValue, 
               int newValue) {
               if (oldValue != newValue) {
                  lejos.nxt.Sound.beep();
               } else {
               }
            }
            
         } // end of superclass
