/*
 * Copyright (c) 2010 Unpublished Work of Novell, Inc. All Rights Reserved.
 *
 * THIS WORK IS AN UNPUBLISHED WORK AND CONTAINS CONFIDENTIAL,
 * PROPRIETARY AND TRADE SECRET INFORMATION OF NOVELL, INC. ACCESS TO
 * THIS WORK IS RESTRICTED TO (I) NOVELL, INC. EMPLOYEES WHO HAVE A NEED
 * TO KNOW HOW TO PERFORM TASKS WITHIN THE SCOPE OF THEIR ASSIGNMENTS AND
 * (II) ENTITIES OTHER THAN NOVELL, INC. WHO HAVE ENTERED INTO
 * APPROPRIATE LICENSE AGREEMENTS. NO PART OF THIS WORK MAY BE USED,
 * PRACTICED, PERFORMED, COPIED, DISTRIBUTED, REVISED, MODIFIED,
 * TRANSLATED, ABRIDGED, CONDENSED, EXPANDED, COLLECTED, COMPILED,
 * LINKED, RECAST, TRANSFORMED OR ADAPTED WITHOUT THE PRIOR WRITTEN
 * CONSENT OF NOVELL, INC. ANY USE OR EXPLOITATION OF THIS WORK WITHOUT
 * AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO CRIMINAL AND CIVIL
 * LIABILITY.
 *
 * ========================================================================
 */
package com.novell.spsample.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * This is the CSS panel
 *
 */
public class CSSPanel extends HTMLPanel
{
	/**
     * Creates a new panel
     */
    public CSSPanel()
    {
        super("div", 
             "<h1>Spiffy UI CSS</h1><br /><br />" + 
              "<div id=\"cssPanelText\">" + 
                  "<p>" + 
                    "This framework uses CSS for all layout.  That makes it easy to change the look and feel of the  " + 
                    "application as well as the layout, the spacing, and the nature of the controls themselves.   " + 
                  "</p>" +
              
                  "<p>" + 
                    "For example: switch to <span id=\"tabnavbutton\"></span>" + 
                  "</p>" +
              
                  "<h2>Page styles</h2>" +
              
                  "<p>" + 
                    "The Spiffy UI framework starts with <a href=\"http://developer.yahoo.com/yui/reset/\">Reset CSS</a> " + 
                    "from YUI.  This allows us to set the CSS styles for every browser to a common starting point and " + 
                    "makes it much easier to maintain UI consistency across different browsers. " + 
                  "</p>" +
              
                  "<p>" + 
                    "There are four main sections in the Spiffy UI:  the header (<code>#mainHeader</code>), the navigation " +
                    "area (<code>#mainNavigation</code>), the content area (<code>#mainContent</code>), and the footer " +
                    "(<code>#mainFooter</code>).  These four areas make up the basic blocking of the application.  They " + 
                    "may each be styled and position separately. " + 
                  "</p>" +
              
                  "<p>" + 
                    "The default CSS style is 12/14 Verdana.  That means 12 pixel sized font with a 14 pixel line height " + 
                    "using Verdana.  Everything in the framework conforms to this 14 pixel line height.  That means each " + 
                    "line is a multiple of 14 so everything lines up vertically." + 
                  "</p>" +
              
                  "<h2>Form styles</h2>" +
                  "<p>" + 
                    "These styles ar extended into forms as well.  There are styles for labels, fields, headers, " + 
                    "and other parts of the form layout. <br /><br />" + 
                    "<img src=\"css_sample.png\" /> " + 
                  "</p>" +
              
                  "<h2>CSS files</h2>" +
                  "<p>" + 
                    "The Spiffy UI framework styles are built into <code>spiffyui.min.css</code>.  This files contains " + 
                    "almost all of the CSS for this framework.  There are a few places where we need to add special " + 
                    "styles to support Internet Explorer.  Those files are in <code>spiffyui.ie.css</code>.  This file " + 
                    "is loaded dynamically in the page if the user is using Internet Explorer." + 
                  "</p>" +
              
                  "<p>" +
                    "There are more styles on the sample form page. " +
                  "</p>" +
    
                  "<h2>Specific styles</h2>" +
    
                  "<p>" +
                    "In addition to for styles and styles for the whole page there are specific styles that are " +
                    "reusable in any part of the application." +
                  "</p>" +
              
                  "<p>" +
                    "<span class=\"weak\">.weak</span> " +
                  "</p>" +
              
                  "<h1>" +
                    "h1" +
                  "</h1>" +
              
                  "<h2 class=\"sectionTitle\">" +
                    "h2" +
                  "</h2>" +
              
                  "<p>" +
                    "Many of the widgets in framework also use custom CSS.  You can see those on the sample widgets page. " +
                    "Explore this sample application and reuse any styles you see here.  <a href=\"http://getfirebug.com/\">" + 
                    "Firebug</a> is your friend." + 
                  "</p>" +
              
                  "<p>" +
                    "The rules we follow in this framework are explained in <a " +
                    "href=\"http://www.zackgrossbart.com/hackito/rpt-css/\">Fluid Grids, Vertical Rhythm, and CSS " +
                    "Blocking</a>." +
                  "</p>" +
    
                  
              "</div>"
             );
        
        getElement().setId("overviewPanel");
        
        RootPanel.get("mainContent").add(this);
        
        setVisible(false);
        
        final Button b = new Button("tab navigation");
        b.addClickHandler(new ClickHandler()
            {
                @Override
                public void onClick(ClickEvent event)
                {
                    if (b.getText().equals("tab navigation")) {
                        RootPanel.get("mainWrap").getElement().addClassName("tabnav");
                        b.setText("menu navigation");
                    } else {
                        RootPanel.get("mainWrap").getElement().removeClassName("tabnav");
                        b.setText("tab navigation");
                    }
                }
            });
        add(b, "tabnavbutton");
        
    }
}
