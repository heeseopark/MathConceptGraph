package heeseopark.MathConceptGraph.Controller;

import heeseopark.MathConceptGraph.Domain.ConceptEdge;
import heeseopark.MathConceptGraph.Domain.ConceptNode;
import heeseopark.MathConceptGraph.Domain.GradeLevel;
import heeseopark.MathConceptGraph.Service.ConceptEdgeService;
import heeseopark.MathConceptGraph.Service.ConceptNodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;
import java.util.List;


// 전체 다 gpt가 써준 것이므로 확인할 필요 있음.
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ConceptNodeService conceptNodeService;
    private final ConceptEdgeService conceptEdgeService;

    @GetMapping("/")
    public String home(Model model) {
        // Add forms to the model
        model.addAttribute("conceptNodeForm", new ConceptNodeForm());
        model.addAttribute("conceptEdgeForm", new ConceptEdgeForm());

        // Add lists of existing nodes and edges to the model
        List<ConceptNode> nodes = conceptNodeService.findAllNodes();
        model.addAttribute("nodes", nodes);

        List<ConceptEdge> edges = conceptEdgeService.findAllEdges();  // Assuming you have this method
        model.addAttribute("edges", edges);

        return "home";
    }

    @PostMapping("/conceptNodes")
    public String createNode(@Valid ConceptNodeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";  // Redirect to home if there are errors
        }

        ConceptNode node = new ConceptNode();
        node.setName(form.getName());
        node.setMeaning(form.getMeaning());
        node.setGrade(GradeLevel.valueOf(form.getGrade()));

        conceptNodeService.createNode(node);
        return "redirect:/";
    }

    @PostMapping("/conceptEdges")
    public String createEdge(@Valid ConceptEdgeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";  // Redirect to home if there are errors
        }

        ConceptEdge edge = new ConceptEdge();
        edge.setName(form.getName());
        edge.setMeaning(form.getMeaning());
        edge.setGrade(GradeLevel.valueOf(form.getGrade()));

        conceptEdgeService.createEdge(edge, form.getStartNode(), form.getEndNode());
        return "redirect:/";
    }

    @GetMapping("/conceptNodes/{id}")
    public String viewNode(@PathVariable Long id, Model model) {
        ConceptNode node = conceptNodeService.findOneById(id);
        model.addAttribute("node", node);
        return "nodeDetail";
    }

    @GetMapping("/conceptEdges/{id}")
    public String viewEdge(@PathVariable Long id, Model model) {
        ConceptEdge edge = conceptEdgeService.findOne(id);  // Assuming you have this method
        model.addAttribute("edge", edge);
        return "edgeDetail";
    }
}
