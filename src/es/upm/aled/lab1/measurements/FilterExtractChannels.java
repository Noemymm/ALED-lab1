package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	
	int[] validChannels;

	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		this.validChannels = validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		EEGModel filteredEEG = new EEGModel();
		Measurement[] eggMeasurements = eeg.getMeasurements();
		for(Measurement m : eggMeasurements) {
			float[] channelsFiltered = new float[validChannels.length];
			int posicion = 0; //innecesaria pero así se entiende mejor el código
			for(int i=0; i<validChannels.length; i++){
				int canalSelected = validChannels[i];
				channelsFiltered[posicion]=m.getChannel(canalSelected);
				posicion++;
			} filteredEEG.addMeasurement(new Measurement(channelsFiltered));
		} 
		
		return filteredEEG; //TODO
	}

}
