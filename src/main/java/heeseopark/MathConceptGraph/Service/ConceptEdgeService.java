package heeseopark.MathConceptGraph.Service;

import heeseopark.MathConceptGraph.Domain.ConceptNode;
import heeseopark.MathConceptGraph.Domain.ConceptEdge;
import heeseopark.MathConceptGraph.Repository.ConceptEdgeRepository;
import heeseopark.MathConceptGraph.Repository.ConceptNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConceptEdgeService {
    
    @Autowired
    ConceptNodeRepository conceptNodeRepository;
    
    @Autowired
    ConceptEdgeRepository conceptEdgeRepository;
    
    @Transactional
    public Long createEdge(ConceptEdge edge, ConceptNode startNode, ConceptNode endNode) {
        edge.setStartNode() = startNode;
        edge.setEndNode() = endNode;
        validateDuplicateEdge(edge);
        validateNodeConnection(edge);
        conceptEdgeRepository.save(edge);
        // node의 sourceEdge, targetEdge는 알아서 업데이트가 되는 것인가?
        return edge.getId();
    }

    private void validateDuplicateEdge(ConceptEdge edge){
        List<ConceptEdge> findEdges = conceptEdgeRepository.findByName(edge.getName());
        if (!findEdges.isEmpty()){
            throw new IllegalStateException(("이미 존재하는 엣지입니다"));
        }
    }

    // gpt 결과 그대로 가져온 거라 한 번 확인해야함
    private void validateNodeConnection(ConceptEdge edge) {
        if (edge.getStartNode() == null || edge.getEndNode() == null) {
            throw new IllegalStateException("Both start and end nodes must be present for an edge.");
        }


        // Optionally, check if the nodes exist in the node repository
        if (!conceptNodeRepository.existById(edge.getStartNode().getId()) ||
                !conceptNodeRepository.existById(edge.getEndNode().getId())) {
            throw new IllegalStateException("Either the start or end node does not exist.");
        }
    }


    public void deleteEdgeById(Long nodeId) {
        if (!conceptEdgeRepository.existById(nodeId)) {
            throw new IllegalStateException("Node that is to be deleted does not exist");
        }

        conceptEdgeRepository.deleteById(nodeId);
    }
    
    public void addIntermediateNode(ConceptEdge currentEdge, ConceptNode addNode, ConceptEdge addEdge){
        // currentNode가 addNode의 앞으로 가는지 뒤로 가는지 if문으로 구분하는 로직도 아마 여기에 있어야 할듯
        // createEdge 여기에서 쓸 수 있을듯 -> 컴포넌트화 첫 활용:)
    }


}
