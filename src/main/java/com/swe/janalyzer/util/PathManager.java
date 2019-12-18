package com.swe.janalyzer.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
		public static PathManager instance;
		private Path defaultPath, customPath;
		private String choice;

		public PathManager(){
				this.defaultPath = Paths.get(System.getProperty("user.home") + "/janalyzer");
				this.choice = Constants.DEFAULT_PATH;
		}

		public static PathManager getInstance() {
				if(instance == null) instance = new PathManager();
				return instance;
		}

		public void choosePath(String choice) {
				switch (choice){
						case Constants.DEFAULT_PATH:
								this.choice = choice;
								break;
						case Constants.CUSTOM_PATH:
								this.choice = choice;
								break;
						default:
								this.choice = Constants.DEFAULT_PATH;
								break;
				}
		}

		public void setCustomPath(Path custom){
				this.customPath = custom;
		}

		public Path getChoosenPath() {
				if(this.choice.equals(Constants.CUSTOM_PATH) && this.customPath != null){
						return this.customPath;
				}
				return this.defaultPath;
		}


}
