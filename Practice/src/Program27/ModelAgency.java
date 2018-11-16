package Program27;

import java.util.Arrays;

public class ModelAgency {

	private String name;
	private Model[] modelInside;

	public ModelAgency(String name) {
		this.name = name;
		this.modelInside = new Model[20];
	}

	public String getName() {
		return name;
	}

	public Model getModelInside(String name) {
		for (int i = 0; i < modelInside.length; i++)
			try {
				if (modelInside[i].getName() == name)
					if (modelInside[i] instanceof TrackModel)
						return (TrackModel) (modelInside[i]);
					else
						return (PhotoModel) (modelInside[i]);
			} catch (java.lang.NullPointerException ex) {
				System.out.println("The problem is - " + ex.getMessage() + " -\nDon't find this Model (name-> " + name
						+ ") in our ModelAgency!");
				break;
			}
		return null;
	}

	public void addModel(Model model) {
		if (model instanceof TrackModel) {
			if (model.getHight() > 170)
				for (int i = 0; i < modelInside.length; i++)
					if (modelInside[i] == null) {
						System.out.println("wellcome TrackModel " + model.getName());
						modelInside[i] = model;
						break;
					}
		} else
			for (int i = 0; i < modelInside.length; i++)
				if (modelInside[i] == null) {
					System.out.println("wellcome PhotoModel " + model.getName());
					modelInside[i] = model;
					break;
				}
	}

	@Override
	public String toString() {
		return "ModelAgency [name=" + name + ", modelInside=" + Arrays.toString(modelInside) + "]";
	}

}
