package heeseopark.MathConceptGraph.Repository;

import heeseopark.MathConceptGraph.Domain.Expression;

import java.util.List;
import java.util.Optional;

public interface ExpressionRepository {
    Expression save(Expression expression);
    Optional<Expression> findById (Long id);
    Optional<Expression> findByName(String name);
    List<Expression> findAll();
}
