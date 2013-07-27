package com.jbsoft.library;

import android.content.Intent;
public class IntentManager {
public static final Intent createYourSpecialIntent(Intent src) {
  return new Intent("YourSpecialIntent").addCategory("YourSpecialCategory").putExtras(src);
}
}