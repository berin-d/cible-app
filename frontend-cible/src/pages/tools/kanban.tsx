import { useState } from 'react';

import { DragDropProvider } from '@dnd-kit/react';
import Draggable from '../../components/commons/Draggable';

export default function KanbanPage() {
    const [isDropped, setIsDropped] = useState(false);


    return (
        <DragDropProvider
            onDragEnd={(event) => {
                if (event.canceled) return;

                const { target } = event.operation;
                setIsDropped(target?.id === 'droppable');
            }}
        >
            {!isDropped && <Draggable />}
        </DragDropProvider>
    );
}