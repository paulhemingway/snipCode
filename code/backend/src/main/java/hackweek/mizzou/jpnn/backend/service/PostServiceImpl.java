package hackweek.mizzou.jpnn.backend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackweek.mizzou.jpnn.backend.dao.PostDAO;
import hackweek.mizzou.jpnn.backend.model.Post;
import hackweek.mizzou.jpnn.backend.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService
{
	
	@Autowired
	private PostDAO postDAO;
		
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public boolean savePost(Post post) 
	{
		if(post.getId() < 1)
		{
			post.setTimestamp(formatter.format(new Date()));			
		}
		
		return postDAO.savePost(post);
	}

	@Override
	public boolean deletePost(int id) 
	{
		return postDAO.deletePost(id);
	}

	@Override
	public Post getPost(int id) 
	{
		return postDAO.getPost(id);
	}

	@Override
	public List<Post> getAllPosts()
	{
		return postDAO.getAllPosts();
	}

}
