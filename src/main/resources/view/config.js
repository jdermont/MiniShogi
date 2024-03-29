import { GraphicEntityModule } from './entity-module/GraphicEntityModule.js';
import { TooltipModule } from './tooltip-module/TooltipModule.js';
import { ToggleModule } from './toggle-module/ToggleModule.js'
import { EndScreenModule } from './endscreen-module/EndScreenModule.js';

// List of viewer modules that you want to use in your game
export const modules = [
	GraphicEntityModule,
	TooltipModule,
	ToggleModule,
	EndScreenModule
];

export const playerColors = [
  '#ff1d5c', // black
  '#22a1e4' // white
];

export const options = [
    ToggleModule.defineToggle({
        toggle: 'westernToggle',
        title: 'Piece Set',
        values: {
            'Western': true,
            'Standard': false
        },
        default: false
    }),
    ToggleModule.defineToggle({
        toggle: 'sfenToggle',
        title: 'Show SFEN',
        values: {
            'ON': true,
            'OFF': false
        },
        default: false
    })
];
