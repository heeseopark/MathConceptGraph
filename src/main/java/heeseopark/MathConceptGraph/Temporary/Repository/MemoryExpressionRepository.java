package heeseopark.MathConceptGraph.Temporary.Repository;

import heeseopark.MathConceptGraph.Temporary.Domain.Expression;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryExpressionRepository implements ExpressionRepository{

    private static Map<Long, Member>

    @Override
    public Expression save(Expression expression) {
        return null;
    }

    @Override
    public Optional<Expression> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Expression> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Expression> findAll() {
        return null;
    }
}
