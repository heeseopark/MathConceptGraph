package heeseopark.MathConceptGraph.Service;

import heeseopark.MathConceptGraph.Domain.ConceptNode;
import heeseopark.MathConceptGraph.Domain.GradeLevel;
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
    public Long createNode(ConceptNode node) {
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

    public List<ConceptNode> findAllNodes(){
        return conceptNodeRepository.findAll();
    }

    public ConceptNode findOneById(Long nodeId){
        return conceptNodeRepository.findOne(nodeId);
    }

    @Transactional
    public void updateNode(ConceptNode updatedNode) {
        if (updatedNode.getId() == null) {
            throw new IllegalArgumentException("Node ID must be provided for updating");
        }

        ConceptNode existingNode = conceptNodeRepository.findOne(updatedNode.getId());

        if (existingNode == null) {
            throw new IllegalStateException("Node with the given ID does not exist");
        }

        existingNode.setName(updatedNode.getName());
        existingNode.setGrade(updatedNode.getGrade());
        existingNode.setMeaning(updatedNode.getMeaning());

        // No need to call the save method; changes will be automatically persisted when the transaction commits
    }


    @Transactional
    public void deleteNodeById(Long nodeId) {
        if (!conceptNodeRepository.existById(nodeId)) {
            throw new IllegalStateException("Node that is to be deleted does not exist");
        }

        conceptNodeRepository.deleteById(nodeId);
    }



    /*
     * make these recommended methods
     * 
     * methods related to CRUD operations
     * 
     *
     * getNodeByid(Long id)
     * updateConceptNode(arguement로 entity가 들어가야하는지 id가 들어가야하는지)
     *
     * 
     * methods related to utility methods
     * 
     * findNodeByName(argument로 string name이 들어가야하는지 entity가 들어가야하는지)
     *  return Long id
     * getNodeByGrade
     * 
     * 서비스 레이어에서는 erorr를 다룰 수 있어야함
     * the serivce layer needs to deal with error detectioning
     * 
     */

    // updating과 관련해서도 DDD를 고려했을 때 update한 결과를 나타내는 node를 쓰는 것이 좋을 것 같다고 생각. (수정하는 field 수가 적더라도)

}
