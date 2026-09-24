package es.upm.aled.lab1.measurements;

import java.util.ArrayList;
import java.util.List;

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
		Measurement[] orMeasurements = eeg.getMeasurements();
		Measurement[] filtMeasurements = new Measurement[eeg.getMeasurements().length];
		int posicion = 0; 
		for(Measurement m : orMeasurements) {
			float[] filtChannels = new float[validChannels.length];
			int c = 0;
			for(int i=0; i<validChannels.length; i++) {
				int validChannel = validChannels[i];
				for(int j=0; j<m.numChannels();j++) {
					if(j==validChannel) {
						filtChannels[c]=m.getChannel(validChannel);
					}
				}
			} filtMeasurements[posicion]=new Measurement(filtChannels);
			posicion++;
		} return new EEGModel(filtMeasurements);
	}
	


}

















