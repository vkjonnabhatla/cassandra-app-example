package example.cassandra.cassandraappexample;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;


public class CassandraConfig extends AbstractCassandraConfiguration {

    public static final String KEYSPACE = "examples";

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"example.cassandra.cassandraappexample"};
    }
}
