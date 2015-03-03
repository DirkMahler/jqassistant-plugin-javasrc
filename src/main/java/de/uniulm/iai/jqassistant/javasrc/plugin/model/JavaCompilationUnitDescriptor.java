package de.uniulm.iai.jqassistant.javasrc.plugin.model;

import com.buschmais.jqassistant.core.store.api.model.FileDescriptor;
import com.buschmais.jqassistant.core.store.api.model.FullQualifiedNameDescriptor;
import com.buschmais.jqassistant.core.store.api.model.NamedDescriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Property;
import com.buschmais.xo.neo4j.api.annotation.Relation.Outgoing;
import de.uniulm.iai.jqassistant.javasrc.plugin.api.annotation.Declares;
import de.uniulm.iai.jqassistant.javasrc.plugin.api.annotation.IsMainType;

import java.util.List;

/**
 * Represents a java compilation unit, meaning one single java source file.
 *
 * @author Steffen Kram
 */
@Label("JavaCompilationUnit")
public interface JavaCompilationUnitDescriptor
        extends FileDescriptor, NamedDescriptor, FullQualifiedNameDescriptor, JavaSourceDescriptor {

    @Property("mayCompile")
    Boolean isMayCompile();

    void setMayCompile(Boolean mayCompile);

    @Outgoing
    @IsMainType
    TypeDescriptor getMainType();

    void setMainType(TypeDescriptor mainType);


    @Outgoing
    @Declares
    List<TypeDescriptor> getDeclaredTypes();

}
