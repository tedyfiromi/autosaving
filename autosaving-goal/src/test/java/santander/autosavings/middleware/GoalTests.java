package santander.autosavings.middleware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.santander.autosavings.middleware.model.Goal;
import com.santander.autosavings.middleware.model.TransactionGoal;
import com.santander.autosavings.middleware.service.GoalService;
import com.santander.autosavings.middleware.utils.UrlRest;


@SpringBootConfiguration()
@SpringBootTest
public class GoalTests {
	
	@MockBean
	private GoalService mockGoalService;
	private Goal goalFrance;
	private Goal goalItaly;
	private List<Goal> listGoals = new ArrayList<>();
	private List<TransactionGoal> transactionsFrance = new ArrayList<>();
	private List<TransactionGoal> transactionsItaly = new ArrayList<>();
	
	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
		mockGoalService = mock(GoalService.class);
		
		transactionsFrance.add(new TransactionGoal("5cf58d24d817ae5a10a7233f", 80.00));			
		transactionsItaly.add(new TransactionGoal("5cf6c1c5d817ae5e28d094f7", 75.00));
		
		goalFrance = new Goal("5cf58d24d817ae5a10a78b3f", "France", 2000.0, 150.0, 0.0, null, null, transactionsFrance);
		goalItaly = new Goal("5cf6c1c5d817ae5e28d094fc", "Italy", 1000.0, 200.0, 0.0, null, null, transactionsItaly);
	
	
		
		listGoals.add(goalFrance);
		listGoals.add(goalItaly);
		
		listGoals.add(goalFrance);
		listGoals.add(goalItaly);
		
		when(mockGoalService.getListAllGoals()).thenReturn(listGoals);
	}
	
	@Test
	public void testGetListGoals() {
		List<Goal> goals = mockGoalService.getListAllGoals();
		assertNotNull(goals);
		assertEquals(2, goals.size());
	}
	
	@Test
	public void testListGoalsURIaccess() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();

	    final String baseUrl = UrlRest.URL_BASE + UrlRest.BASE + UrlRest.GOAL_LIST;
	    URI uri = new URI(baseUrl);

	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

	    assertEquals(200, result.getStatusCodeValue());
	    assertEquals(true, result.getBody().contains("id"));
	}
	
	@Test
	public void testCreateGoal() {
		
	}

}
