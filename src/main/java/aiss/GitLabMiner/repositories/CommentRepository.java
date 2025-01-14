package aiss.GitLabMiner.repositories;

import aiss.GitLabMiner.models.Comment;
import aiss.GitLabMiner.models.Issue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {

    List<Comment> comments = new ArrayList<>();

    public CommentRepository(){

    }

    public List<Comment> findAll(){ return comments; }

    public Comment findOne(String id){
        return comments.stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Comment> getIssuesComments (Issue issue){
        return comments.stream()
                .filter(comment -> comment.getIssue().equals(issue))
                .collect(Collectors.toList());
    }

}
