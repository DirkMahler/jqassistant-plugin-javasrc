package de.uniulm.iai.jqassistant.javasrc.plugin.model;

import com.buschmais.jqassistant.core.store.api.model.FullQualifiedNameDescriptor;
import com.buschmais.jqassistant.core.store.api.model.NamedDescriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Property;
import com.buschmais.xo.neo4j.api.annotation.Relation;
import com.buschmais.xo.neo4j.api.annotation.Relation.Outgoing;
import de.uniulm.iai.jqassistant.javasrc.plugin.api.annotation.Declares;

import java.util.List;

/**
 * @author Steffen Kram
 */
@Label(value = "Type", usingIndexedPropertyOf = FullQualifiedNameDescriptor.class)
public interface TypeDescriptor extends FullQualifiedNameDescriptor, NamedDescriptor, BlockLineSpanDescriptor,
        JavaSourceDescriptor {

    /**
     * Is this the main type definition of the compilation unit?
     *
     * @return True if this is the main type definition.
     */
    @Property("mainType")
    boolean isMainType();


    /**
     * Set if this is the main type definition.
     *
     * @param isMain
     *      Set to true for main type definitions.
     */
    void setMainType(boolean isMain);

    /**
     * Return the super class.
     *
     * @return The super class.
     */
    @Relation("EXTENDS")
    TypeDescriptor getSuperClass();

    /**
     * Set the super class.
     *
     * @param superClass
     *            The super class.
     */
    void setSuperClass(TypeDescriptor superClass);

    /**
     * Return the implemented interfaces.
     *
     * @return The implemented interfaces.
     */
    @Relation("IMPLEMENTS")
    List<TypeDescriptor> getInterfaces();

    /**
     * Return the declared methods.
     *
     * @return The declared methods.
     */
    @Outgoing
    @Declares
    List<MethodDescriptor> getDeclaredMethods();

    /**
     * Return the declared fields.
     *
     * @return The declared fields.
     */
    @Outgoing
    @Declares
    List<FieldDescriptor> getDeclaredFields();

    /**
     * Return the declared members, i.e. fields and methods.
     *
     * @return The declared members.
     */
    @Outgoing
    @Declares
    List<MemberDescriptor> getDeclaredMembers();

    /**
     * Return the declared inner classes.
     *
     * @return The declared inner classes.
     */
    @Relation("DECLARES")
    List<TypeDescriptor> getDeclaredInnerTypes();

}