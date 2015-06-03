# ReturnLossCalc
Return Loss Estimator for cellular network macro sites.

Author: Tim Chandler
Email: Tim@ridgeequipment.com


This Android App will allow users to input a build a line profile given industry standard products and view the resulting expected Return Loss.

Initial Commit built using Android Studio for API version 17 or higher. Tested most functions on emulator nexus 5 api version 22. 


<ul>Todo:

<li>Build Layout elements
<li>Fill Components arrays with more products
<li>Implement a UI to get inputs from user
</ul>

<ul>Files:
<li>Java Class Files:
<ul><li>MainActivity.java - Will be main interface between UI and Backend 
<li>CustomMethods.java - A compilation of functions to be used in calculations
<li>CableTypes.java - Cable array and custom functions for obtaining loss @ specific freq
<li>Components.java - Handles all other possible components that could be in the system
</ul>
<li>XML
<ul><li>Currently all standard XML layout and resources files standard to Android Studio
</ul>
</ul>

I have expiremented with UI elements in other projects and will be starting to implement them as soon as I find a working set. Currently looking to use

// ---- Element ---- //
/Linear Layout - Element# /
/Spinner - Component Select/
/Spinner - Manufacturer Select/
/Spinner - Model Select/
(Optional)/Edit Text - Length Entry for Cable/
/End Linear Layout - Element#/
// ---- End Element ----//



