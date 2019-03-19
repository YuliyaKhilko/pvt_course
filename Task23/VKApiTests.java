package core;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VKApiTests {

	private HttpClient client;
	private static String accessToken = "707b89a0fb93766637baeb918be0fd8e332abe5f90fc2cade3a496bcaec144f48313acc6279f476d92a50";
	private static String ownerId = "536083852";
	private static String version = "5.92";

	@Before
	public void setUp() {
		client = HttpClientBuilder.create().build();
	}

	@Test
	public void testAddPostToWall() throws ClientProtocolException, URISyntaxException, IOException {
		Assert.assertEquals(200, addWallPost().getStatusLine().getStatusCode());
	}

	@Test
	public void testEditWallPost() throws URISyntaxException, ClientProtocolException, IOException {
		String postId = getWallPostId(addWallPost());
		Assert.assertEquals(200, editWallPost(postId).getStatusLine().getStatusCode());
	}

	@Test
	public void testRemoveWallPost() throws ParseException, ClientProtocolException, IOException, URISyntaxException {
		String postId = getWallPostId(addWallPost());
		Assert.assertEquals(200, deleteWallPost(postId).getStatusLine().getStatusCode());
	}

	private HttpResponse addWallPost() throws URISyntaxException, ClientProtocolException, IOException {
		String message = "test";
		URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("message", message).setParameter("v", version);
		HttpPost request = new HttpPost(builder.build());
		return client.execute(request);
	}

	private HttpResponse editWallPost(String postId) throws URISyntaxException, ClientProtocolException, IOException {
		String message = "test_edited";
		URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("post_id", postId).setParameter("message", message).setParameter("v", version);
		HttpGet request = new HttpGet(builder.build());
		return client.execute(request);
	}

	private HttpResponse deleteWallPost(String postId) throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.delete?");
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("post_id", postId).setParameter("v", version);
		HttpGet request = new HttpGet(builder.build());
		return client.execute(request);
	}

	private String getWallPostId(HttpResponse response) throws ParseException, IOException {
		return EntityUtils.toString(response.getEntity()).replaceAll("[^0-9]", "");
	}

}
