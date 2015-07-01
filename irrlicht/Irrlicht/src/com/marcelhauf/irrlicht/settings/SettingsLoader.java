package com.marcelhauf.irrlicht.settings;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class SettingsLoader extends AsynchronousAssetLoader<Settings, SettingsLoader.SettingsParameter> {
	public SettingsLoader(FileHandleResolver resolver) {
		super(resolver);
	}

	Json json = new Json();
	
	public static class SettingsParameter extends AssetLoaderParameters<Settings>{
		public Settings settings;
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, SettingsParameter parameter) {
		if (parameter != null) {
			parameter.settings = json.fromJson(Settings.class, file);
		}
	}

	@Override
	public Settings loadSync(AssetManager manager, String fileName, FileHandle file, SettingsParameter parameter) {
		return json.fromJson(Settings.class, file);
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, SettingsParameter parameter) {
		return null;
	}
	
}
