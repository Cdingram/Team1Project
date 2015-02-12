package ca.ualberta.cs.team1travelexpenseapp.test;

import java.util.Date;

import android.R;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import junit.framework.TestCase;

public class ClaimantClaimListTest extends ActivityInstrumentationTestCase2<ClaimActivity> {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//US01.01.01
	public void testAddClaim() {
		Claim claim = new Claim();
		claim.setName("name");
		claim.setStartDate(new Date(2000,11,11));
		claim.setEndDate(new Date(2015,12,12));
		final String expected = "name";
		final String actual = claim.getName();
		assertEquals("name?",expected,actual);
		assertEquals("start date?",new Date(2000,11,11),claim.getStartDate());
		assertEquals("end date?",new Date(2015,12,12),claim.getEndDate());
	}

	

	//US01.02.01
	public void testEnterDestination() {
		Claim claim = new Claim();
		claim.addDestination("dest 1");
		claim.addDestination("dest 2");
		assertEquals("Destination","dest 1",claim.getDestination(1));
		claim.editDestination(1,"dest 3");
		assertEquals("Destination","dest 3",claim.getDestination(1));
		assertTrue("contains claim", claim.contains("dest 3"));
		assertEquals("has destination",3,claim.destinationCount());
		
	}
	
	//US01.03.01
	public void ViewClaimTest() {
		ClaimActivity activity = getActivity();
		TextView view = (TextView) activity.findViewByID(R.id.claimtext);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
		assertNotNull("activity",activity);
		assertNotNull("textview",view);
	}
	
	//US01.04.01
	public void EditClaimTest() {
		Claim claim = new Claim();
		claim.setName("name");
		claim.setStartDate(new Date(2000,11,11));
		claim.setEndDate(new Date(2015,12,12));
		final String expected = "test";
		final String actual = claim.getName();
		claim.setName("name");
		claim.setStartDate(new Date(2100,11,11));
		claim.setEndDate(new Date(2115,12,12));
		assertEquals("name?",expected,actual);
		assertEquals("start date?",new Date(2100,11,11),claim.getStartDate());
		assertEquals("end date?",new Date(2115,12,12),claim.getEndDate());
		
	}
	//US01.05.01
	public void DeleteClaimTest() {
        final Button deleteButton =
                (Button) getActivity()
                .findViewById(R.id.deleteclaimbutton);
		Claim claim = new Claim();
		ClaimsListController list = new ClaimsListController();
		list.add(claim);
		assertTrue("not empty list",list.length()==1);
		list.remove(claim);
		assertTrue("empty list",list.length()==0);
		list.add(claim);
        TouchUtils.clickView(this, deleteButton);
		assertTrue("empty list",list.length()==0);
		
	}
	//US01.06.01
	public void saveClaims() {
		ClaimActivity activity = getActivity();
		Claim claim = new Claim();
		claim.setName("name");
		claim.setStartDate(new Date(2000,11,11));
		claim.setEndDate(new Date(2015,12,12));
		final String expected = "name";
		final String actual = claim.getName();
		activity.onDestroy();
		activity.onCreate();		
		assertEquals("name?",expected,actual);
		assertEquals("start date?",new Date(2000,11,11),claim.getStartDate());
		assertEquals("end date?",new Date(2015,12,12),claim.getEndDate());
		
	}
	

}