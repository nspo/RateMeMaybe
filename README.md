RateMeMaybe
===========
- Asks the user if (s)he wants to open the Play Store to rate your application when certain requirements are met (see below). This can and should be configured to be very cautious. **Don't annoy your users!**
- Dialog icon, title, message and so on can be **easily customized**
- The sample Activity uses SherlockFragmentActivity (from [ActionBarSherlock](http://actionbarsherlock.com)), but you can use a normal FragmentActivity if you do not use ABS. If you also do not use the android support library, you can change `mActivity.getSupportFragmentManager()` to `mActivity.getFragmentManager()`
- Code is heavily based on [AppRate](https://github.com/TimotheeJeannin/AppRate) by Timothee Jeannin
- License: MIT


To use it, you can simply copy [RateMeMaybe.java](https://github.com/nspo/RateMeMaybe/blob/master/code/src/com/kopfgeldjaeger/ratememaybe/RateMeMaybe.java) and [RateMeMaybeFragment.java](https://github.com/nspo/RateMeMaybe/blob/master/code/src/com/kopfgeldjaeger/ratememaybe/RateMeMaybeFragment.java) into your project.

Example usage in your `(Sherlock)FragmentActivity`:
```java
RateMeMaybe rmm = new RateMeMaybe(this);
rmm.setPromptMinimums(10, 14, 10, 30);
rmm.run();

// More customized example
RateMeMaybe rmm = new RateMeMaybe(this);
rmm.setPromptMinimums(10, 14, 10, 30);
rmm.setDialogMessage("You really seem to like this app, "
				+"since you have already used it %totalLaunchCount% times! "
				+"It would be great if you took a moment to rate it.");
rmm.setDialogTitle("Rate this app");
rmm.setPositiveBtn("Yeeha!");
rmm.run();
```

Methods:
```java
	/**
	 * Sets requirements for when to prompt the user.
	 * 
	 * @param minLaunchesUntilInitialPrompt
	 *            Minimum of launches before the user is prompted for the first
	 *            time. One call of .run() counts as launch.
	 * @param minDaysUntilInitialPrompt
	 *            Minimum of days before the user is prompted for the first
	 *            time.
	 * @param minLaunchesUntilNextPrompt
	 *            Minimum of launches before the user is prompted for each next
	 *            time. One call of .run() counts as launch.
	 * @param minDaysUntilNextPrompt
	 *            Minimum of days before the user is prompted for each next
	 *            time.
	 */
	public void setPromptMinimums(int minLaunchesUntilInitialPrompt,
			int minDaysUntilInitialPrompt, int minLaunchesUntilNextPrompt,
			int minDaysUntilNextPrompt)
	/**
	 * Sets the title of the dialog shown to the user
	 * @param dialogTitle
	 */
	public void setDialogTitle(String dialogTitle)

	/**
	 * Sets the message shown to the user. %totalLaunchCount% will be replaced
	 * with total launch count.
	 * 
	 * @param dialogMessage
	 *            The message shown
	 */
	public void setDialogMessage(String dialogMessage)

	/**
	 * Sets name of button that opens Play Store entry
	 * 
	 * @param positiveBtn
	 */
	public void setPositiveBtn(String positiveBtn)

	/**
	 * Sets name of neutral button
	 * 
	 * @param neutralBtn
	 */
	public void setNeutralBtn(String neutralBtn)

	/**
	 * Sets name of button that makes the prompt never show again
	 * 
	 * @param negativeBtn
	 */
	public void setNegativeBtn(String negativeBtn)

	/**
	 * @param customIcon
	 *            Drawable id of custom icon
	 */
	public void setIcon(int customIcon)

	/**
	 * @param handleCancelAsNeutral
	 *            Standard is true. If set to false, a back press (or other
	 *            things that lead to the dialog being cancelled), will be
	 *            handled like a negative choice (click on "Never").
	 */
	public void setHandleCancelAsNeutral(Boolean handleCancelAsNeutral)
	
	/**
	 * Sets an additional callback for when the user has made a choice.
	 * @param listener
	 */
	public void setAdditionalListener(OnRMMUserChoiceListener listener)
	
	/**
	 * Standard is false. Whether the run method is executed even if no Play
	 * Store is installed on device.
	 * 
	 * @param runWithoutPlayStore
	 */
	public void setRunWithoutPlayStore(Boolean runWithoutPlayStore)

	/**
	 * Reset the launch logs
	 */
	public static void resetData(FragmentActivity activity)

	/**
	 * Forces the dialog to show, even if the requirements are not yet met. Does
	 * not affect prompt logs. Use with care.
	 */
	public void forceShow()
```
