package org.openforis.calc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.namespace.QName;

import org.openforis.calc.model.Survey;
import org.openforis.calc.model.SurveyUnit;
import org.openforis.calc.persistence.SurveyDao;
import org.openforis.calc.persistence.SurveyUnitDao;
import org.openforis.collect.model.CollectSurvey;
import org.openforis.collect.persistence.xml.CollectSurveyIdmlBinder;
import org.openforis.idm.metamodel.AttributeDefinition;
import org.openforis.idm.metamodel.BooleanAttributeDefinition;
import org.openforis.idm.metamodel.CodeAttributeDefinition;
import org.openforis.idm.metamodel.EntityDefinition;
import org.openforis.idm.metamodel.NodeDefinition;
import org.openforis.idm.metamodel.NumberAttributeDefinition;
import org.openforis.idm.metamodel.Schema;
import org.openforis.idm.metamodel.xml.IdmlParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author G. Miceli
 *
 */
public class CollectLoader {
	
	@Autowired
	private CollectSurveyIdmlBinder idmlBinder;
	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private SurveyUnitDao surveyUnitDao;
	
	private Survey survey;
	
	private static final String lang = "en";
	private static final String idml = "/home/gino/workspace/tzdata/tanzania-naforma.xml";
	private static final String CALC_IDML_NAMESPACE = "http://www.openforis.org/calc/idml";
	private static final QName UNIT_NAME_ATTRIBUTE = new QName(CALC_IDML_NAMESPACE, "unitName");
	private static final QName UNIT_TYPE_ATTRIBUTE = new QName(CALC_IDML_NAMESPACE, "unitType");
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectLoader loader = ctx.getBean(CollectLoader.class);
		CollectSurvey cs = loader.loadIdml(idml);

		loader.importSurvey(ctx, cs);
	}

	@Transactional
	synchronized 
	private  void importSurvey(ClassPathXmlApplicationContext ctx, CollectSurvey cs) {
		survey = new Survey();
		survey.setName(cs.getProjectName(lang));
		survey.setUri(cs.getUri());
		surveyDao.insert(survey);
		System.out.println("Survey: " +survey.getName()+" ("+survey.getId()+")");
		Schema schema = cs.getSchema();
		traverse(schema);
	}

	private void traverse(Schema schema) {
		List<EntityDefinition> roots = schema.getRootEntityDefinitions();
		for (EntityDefinition root : roots) {
			traverse(root, null);
		}
	}

	private void traverse(EntityDefinition node, SurveyUnit parentUnit) {
		String unitType = node.getAnnotation(UNIT_TYPE_ATTRIBUTE);
		String unitName = node.getAnnotation(UNIT_NAME_ATTRIBUTE);
		if ( unitType != null && unitName != null ) {
			parentUnit = importSurveyUnit(parentUnit, unitType, unitName);
		} else if ( parentUnit != null && node.isMultiple() ) {
			System.out.println("Skipping unmapped entity: "+node.getPath());
			return;
		}
		for (NodeDefinition child : node.getChildDefinitions()) {
			if ( parentUnit != null && child instanceof AttributeDefinition ) {
				importVariable(parentUnit, (AttributeDefinition) child);
			} else if ( child instanceof EntityDefinition ){
				traverse((EntityDefinition) child, parentUnit);
			}
		}
	}

	private void importVariable(SurveyUnit parentUnit, AttributeDefinition attr) {
		if ( attr instanceof CodeAttributeDefinition ) {
			importCatVariable((CodeAttributeDefinition) attr);
			System.out.println("Cat. variable: "+parentUnit.getName()+"."+attr.getName());
		} else if ( attr instanceof BooleanAttributeDefinition && !attr.isMultiple() ) {
			importCatVariable((BooleanAttributeDefinition) attr);
			System.out.println("Cat. variable: "+parentUnit.getName()+"."+attr.getName());
		} else if ( attr instanceof NumberAttributeDefinition  && !attr.isMultiple() ) {
			importNumVariable((NumberAttributeDefinition) attr);
			System.out.println("Num. variable: "+parentUnit.getName()+"."+attr.getName());
		} else {
			System.out.println("Skipping unsupported attribute: "+attr.getPath());
		}
		// TODO Auto-generated method stub
		
	}

	private void importNumVariable(NumberAttributeDefinition attr) {
		// TODO Auto-generated method stub
		
	}

	private void importCatVariable(BooleanAttributeDefinition attr) {
		// TODO Auto-generated method stub
		
	}

	private void importCatVariable(CodeAttributeDefinition attr) {
		// TODO Auto-generated method stub
		
	}

	private SurveyUnit importSurveyUnit(SurveyUnit parentUnit, String unitType, String unitName) {
		SurveyUnit unit = new SurveyUnit();
		unit.setSurveyId(survey.getId());
		unit.setName(unitName);
		unit.setType(unitType);
		if ( parentUnit != null ) {
			unit.setParentId(parentUnit.getId());
		}
		surveyUnitDao.insert(unit);
		System.out.println("Survey unit: " +unit.getName()+" ("+unit.getId()+")");
		return unit;
	}

	private  CollectSurvey loadIdml(String idml) 
				throws FileNotFoundException, IdmlParseException {
		FileReader reader = new FileReader(idml);
		CollectSurvey cs = (CollectSurvey) idmlBinder.unmarshal(reader);
		return cs;
	}
}