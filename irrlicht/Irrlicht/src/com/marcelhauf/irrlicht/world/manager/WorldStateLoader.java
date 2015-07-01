package com.marcelhauf.irrlicht.world.manager;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class WorldStateLoader extends AsynchronousAssetLoader<WorldState, WorldStateLoader.WorldStateParameter>{
	Json json = new Json();
	
	public WorldStateLoader(FileHandleResolver resolver) {
		super(resolver);
	}

	public static class WorldStateParameter extends AssetLoaderParameters<WorldState>{
		public WorldState world;
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName,
			FileHandle file, WorldStateParameter parameter) {
		if (parameter != null) {
			parameter.world = json.fromJson(WorldState.class, file);
		}
	}

	@Override
	public WorldState loadSync(AssetManager manager, String fileName,
			FileHandle file, WorldStateParameter parameter) {
		return json.fromJson(WorldState.class, file);
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName,
			FileHandle file, WorldStateParameter parameter) {
		return null;
	}
}
