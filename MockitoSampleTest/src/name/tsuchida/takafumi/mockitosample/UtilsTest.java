package name.tsuchida.takafumi.mockitosample;

import name.tsuchida.takafumi.mockitosample.Utils.ResultListener;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class UtilsTest extends TestCase {
	
	ResultListener mockResultListener;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mockResultListener = mock(ResultListener.class);
	}

	public void testInvalidJson() {
		Utils.handleJson("", mockResultListener);
		verify(mockResultListener, only()).onError();
	}
	
	public void testNoStatusKey() {
	    Utils.handleJson("{\"State\":\"hoge1\"}", mockResultListener);  
	    verifyNoMoreInteractions(mockResultListener);
	}
	
	public void testInvalidStatusValue() {
		Utils.handleJson("{\"Status\":\"hoge3\"}", mockResultListener);
		verifyNoMoreInteractions(mockResultListener);
	}
	
	public void testHoge1() {
		Utils.handleJson("{\"Status\":\"hoge1\"}", mockResultListener);
		verify(mockResultListener, only()).onHoge1();
	}
	
	public void testHoge2() {
		Utils.handleJson("{\"Status\":\"hoge2\"}", mockResultListener);
		verify(mockResultListener, only()).onHoge2();
	}
}
