package name.tsuchida.takafumi.mockitosample;

import org.mockito.ArgumentCaptor;

import name.tsuchida.takafumi.mockitosample.Utils2.ResultListener;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class Utils2Test extends TestCase {
	
	ResultListener mockResultListener;

	protected void setUp() throws Exception {
		super.setUp();
		mockResultListener = mock(ResultListener.class);
	}
	
	public void testStatusKey() {
		Utils2.handleJson("{\"Status\":\"hoge1\"}", mockResultListener);
		
		ArgumentCaptor<String> statusCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Long> timeCaptor = ArgumentCaptor.forClass(Long.class);
		
		verify(mockResultListener, only()).handleStatus(statusCaptor.capture(), timeCaptor.capture());
		
		String status = statusCaptor.getValue();
		long time = timeCaptor.getValue();
		assertEquals("hoge1", status);
		
		System.out.println("Status = " + status + ", time = " + time);
	}
	
	public void testNoStatusKey() {
		Utils2.handleJson("{\"State\":\"hoge1\"}", mockResultListener);
		verify(mockResultListener, only()).handleStatus(eq(""), anyLong());
	}
}
