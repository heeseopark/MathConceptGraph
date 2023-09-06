package heeseopark.MathConceptGraph.Service;

import heeseopark.MathConceptGraph.Domain.ConceptNode;
import heeseopark.MathConceptGraph.Repository.ConceptNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConceptNodeService {

    @Autowired
    ConceptNodeRepository conceptNodeRepository;

    @Transactional
    public Long join(ConceptNode node){
        validateDuplicateNode(node);
        conceptNodeRepository.save(node);
        return node.getId();
    }

    private void validateDuplicateNode(ConceptNode node){
        List<ConceptNode> findNodes = conceptNodeRepository.findByName(node.getName());
        if (!findNodes.isEmpty()){
            throw new IllegalStateException(("이미 존재하는 노드입니다"));
        }
    }

    public List<ConceptNode> findNodes(){
        return conceptNodeRepository.findAll();
    }

    public ConceptNode findOne(Long nodeId){
        return conceptNodeRepository.findOne(nodeId);
    }

}
