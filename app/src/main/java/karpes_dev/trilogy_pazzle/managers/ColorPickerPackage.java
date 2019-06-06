package karpes_dev.trilogy_pazzle.managers;

import java.util.HashMap;
import java.util.Map;

import karpes_dev.trilogy_pazzle.abstractions.IColorPickerListener;
import karpes_dev.trilogy_pazzle.abstractions.IPackage;
import karpes_dev.trilogy_pazzle.abstractions.ISettingModel;
import karpes_dev.trilogy_pazzle.common.Common;
import karpes_dev.trilogy_pazzle.listeners.NumbersColorPickerListener;
import karpes_dev.trilogy_pazzle.listeners.PathColorPickerListener;

public class ColorPickerPackage implements IPackage<IColorPickerListener> {

    private Map<String, IColorPickerListener> colorPickerListenerMap;
    private ISettingModel settingModel;

    public ColorPickerPackage(ISettingModel settingModel) {
        colorPickerListenerMap = new HashMap<>();
        this.settingModel = settingModel;
        init();
    }

    private void init() {
        IColorPickerListener pathColorPickerListener = new PathColorPickerListener(settingModel);
        colorPickerListenerMap.put(Common.PATH, pathColorPickerListener);

        IColorPickerListener numbersColorPickerListener = new NumbersColorPickerListener(settingModel);
        colorPickerListenerMap.put(Common.NUMBERS, numbersColorPickerListener);
    }

    @Override
    public IColorPickerListener get(String key) {
        return colorPickerListenerMap.get(key);
    }
}
